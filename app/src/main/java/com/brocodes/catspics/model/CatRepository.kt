package com.brocodes.catspics.model


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.brocodes.catspics.data.CatRetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatRepository(private val catRetrofitClient: CatRetrofitClient) {
    private var kittensList = MutableLiveData<List<ImageItem>>()

    fun loadKittens() : MutableLiveData<List<ImageItem>>{
        Log.d("Load Kittens function", "Beep boop: this method was called")
        val call = catRetrofitClient.getPixabayMethods().getKittens(api_key, queryValue)
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

        return kittensList
    }

    companion object{
        private const val queryValue = "kittens"
        private const val api_key = "16180650-cc5b3804ae28c4b936b61007f"
    }


}