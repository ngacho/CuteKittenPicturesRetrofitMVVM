package com.brocodes.catspics.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayMethods {

    @GET("/api/")
    fun getKittens(@Query("key") key: String, @Query("q") queryValue: String): Call<PixabayResponse>
}