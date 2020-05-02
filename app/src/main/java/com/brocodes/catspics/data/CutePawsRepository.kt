package com.brocodes.catspics.data


import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CutePawsRepository (private val pixabayMethods: PixabayMethods) {
    private var kittensList = mutableListOf<ImageItem>()
    private var liveKittensList = MutableLiveData<List<ImageItem>>()
    private lateinit var call: Call<PixabayResponse>

    fun loadKittens(petType : String) : MutableLiveData<List<ImageItem>>{
        Log.d("Load Kittens function", "Beep boop: this method was called")
        call = pixabayMethods.getPaws(queryValue = petType)
        call.enqueue(object : Callback<PixabayResponse> {
            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                Log.d("Response", "Beep boop, response found")
                kittensList.addAll(response.body()!!.hits)
                liveKittensList.value = kittensList

            }

            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.d("Response", "Beep boop, response not found. Error Message: ${t.message} ")
            }

        })

        return liveKittensList
    }

    fun loadMoreKittens(petType: String, resultPage: Int ) : MutableLiveData<List<ImageItem>>{
        Log.i("Load More Kittens", "Beep Boop, loading more kitten pics")
        call = pixabayMethods.loadMorePaws(queryValue = petType, resultPage = resultPage)
        call.enqueue(object : Callback<PixabayResponse>{
            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.e("Beep Boop", "Loading more kittens failed ${t.message}")
            }

            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                Log.d("More Kittens", "Beep boop, response found")
                kittensList.addAll(response.body()!!.hits)
                liveKittensList.value = kittensList
            }


        })

        return liveKittensList

    }

}