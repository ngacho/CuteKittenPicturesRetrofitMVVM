package com.brocodes.catspics.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brocodes.catspics.data.RetrofitBuilder
import com.brocodes.catspics.model.ImageItem
import com.brocodes.catspics.model.PixabayResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class KittenViewModel(private val retrofitBuilder: RetrofitBuilder) : ViewModel() {

    private var kittensList = MutableLiveData<List<ImageItem>>()

    fun getKittens(): LiveData<List<ImageItem>> {
        loadKittens()
        return kittensList
    }

    private fun loadKittens(){
        Log.d("Load Kittens function", "Beep boop: this method was called")
        val call = retrofitBuilder.pixabayAccessApi.getKittens(api_key, queryValue)
        call.enqueue(object : Callback<PixabayResponse> {
            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                Log.d("Response", "Beep boop, response found")
                val pixabayResponse = response.body()!!
                Log.d("Response successful", response.toString())
                kittensList.value = pixabayResponse.hits
            }

            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                Log.d("Response", "Beep boop, response not found. Error Message: ${t.message} ")
            }

        })
    }

    companion object{
        private val queryValue = "kittens"
        private val api_key = "16180650-cc5b3804ae28c4b936b61007f"
    }
}

