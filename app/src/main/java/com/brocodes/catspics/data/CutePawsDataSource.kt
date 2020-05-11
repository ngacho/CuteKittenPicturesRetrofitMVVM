package com.brocodes.catspics.data

import android.util.Log
import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


class CutePawsDataSource @Inject constructor(private val pixabayMethods: PixabayMethods, private val petType : String) : PageKeyedDataSource<Int, ImageItem>() {

    private var page = 1

    private val job = Job()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ImageItem>) {
        scope.launch {
            try {
                val response = pixabayMethods.getPaws(queryValue = petType)
                val imageItems = response.body()?.hits
                callback.onResult(  imageItems ?: listOf(), 0, page+1)
            }catch (exception : Exception){
                Log.e("Cute Paws data source", "Failed to fetch data!")
            }

        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        scope.launch {
            try {
                val response = pixabayMethods.loadMorePaws(queryValue = petType, resultPage = params.key)
                val imageItems = response.body()?.hits
                callback.onResult(  imageItems ?: listOf(), page+1)
            } catch (e: Exception) {
                Log.i("CutePawsDataSource", e.message.toString())
            }
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        scope.launch {
            try {
                val response = pixabayMethods.loadMorePaws(queryValue = petType, resultPage = params.key)
                val imageItems = response.body()?.hits
                callback.onResult(  imageItems ?: listOf(), page - 1)
            } catch (e: Exception) {
                Log.i("CutePawsDataSource", e.message.toString())
            }
        }
    }
}