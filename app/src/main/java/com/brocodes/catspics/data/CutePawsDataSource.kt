package com.brocodes.catspics.data

import android.util.Log
import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


class CutePawsDataSource @Inject constructor(
    private val pixabayMethods: PixabayMethods,
    private val petType: String
) : PageKeyedDataSource<Int, ImageItem>() {

    private var page = 1

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ImageItem>
    ) {
        scope.launch {
            try {
                val response = pixabayMethods.getPaws(queryValue = petType)
                val imageItems = response.body()?.hits
                callback.onResult(imageItems ?: listOf(), 0, page + 1)
                Log.d("DataSource Beep Boop", "${imageItems?.size ?: 0} Images found")
            } catch (exception: Exception) {
                Log.e("DataSource Beep Boop", "Failed to fetch data: ${exception.message}")
            }

        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        scope.launch {
            try {
                val response =
                    pixabayMethods.loadMorePaws(queryValue = petType, resultPage = params.key)
                val imageItems = response.body()?.hits
                callback.onResult(imageItems ?: listOf(), page + 1)
                Log.d("DataSource Beep Boop", "${imageItems?.size ?: 0} Images found")
            } catch (e: Exception) {
                Log.e("DataSource Beep Boop", "Failed to fetch data: ${e.message}")
            }
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        scope.launch {
            try {
                val response =
                    pixabayMethods.loadMorePaws(queryValue = petType, resultPage = params.key)
                val imageItems = response.body()?.hits
                callback.onResult(imageItems ?: listOf(), page - 1)
                Log.d("DataSource Beep Boop", "${imageItems?.size ?: 0} Images found")
            } catch (e: Exception) {
                Log.e("DataSource Beep Boop", "Failed to fetch data: ${e.message}")
            }
        }
    }
}