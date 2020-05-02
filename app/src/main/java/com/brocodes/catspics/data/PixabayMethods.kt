package com.brocodes.catspics.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayMethods {

    @GET("/api/")
    fun getPaws(
        @Query("key") key: String = "16180650-cc5b3804ae28c4b936b61007f",
        @Query("q") queryValue: String
    ): Call<PixabayResponse>

    @GET("/api/")
    fun loadMorePaws(
        @Query("key") key: String = "16180650-cc5b3804ae28c4b936b61007f",
        @Query("q") queryValue: String,
        @Query("page") resultPage : Int
    ) : Call<PixabayResponse>
}