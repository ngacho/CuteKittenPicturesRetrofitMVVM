package com.brocodes.catspics.data

import android.util.Log
import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CutePawsDataSource @Inject constructor(private val pixabayMethods: PixabayMethods, private val petType : String) : PageKeyedDataSource<Int, ImageItem>() {

    private var page = 1

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, ImageItem>) {
        pixabayMethods
            .getPaws(queryValue = petType)
            .enqueue(object : Callback<PixabayResponse>{
            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.d("Response", "Beep boop, response not found")
            }

            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                Log.i("Load Before", "Total items found : ${response.body()?.hits?.size}")
                val listing = response.body()
                val imageItems = listing?.hits
                callback.onResult(imageItems ?: listOf(), page - 1, page + 1)

            }

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        pixabayMethods
            .loadMorePaws(queryValue = petType, resultPage = params.key)
            .enqueue(object : Callback<PixabayResponse>{
            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.d("Response", "Beep boop, response not found")
            }

            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                Log.i("Load Before", "Total items found : ${response.body()?.hits?.size}")
                val listing = response.body()
                val imageItems = listing?.hits
                callback.onResult(imageItems ?: listOf(), page + 1)

            }

        })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, ImageItem>) {
        pixabayMethods
            .loadMorePaws(queryValue = petType, resultPage = params.key)
            .enqueue(object : Callback<PixabayResponse>{
            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.d("Response", "Beep boop, response not found")
            }

            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                Log.i("Load Before", "Total items found : ${response.body()?.hits?.size}")
                val listing = response.body()
                val imageItems = listing?.hits
                callback.onResult(imageItems ?: listOf(), page - 1)
            }

        })
    }
}