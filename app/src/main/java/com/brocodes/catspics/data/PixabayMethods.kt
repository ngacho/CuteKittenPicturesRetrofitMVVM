package com.brocodes.catspics.data

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayMethods {

    @GET("/api/")
    suspend fun getPaws(
        @Query("key") key: String = "16180650-cc5b3804ae28c4b936b61007f",
        @Query("q") queryValue: String
    ): Response<PixabayResponse>

    @GET("/api/")
    suspend fun loadMorePaws(
        @Query("key") key: String = "16180650-cc5b3804ae28c4b936b61007f",
        @Query("q") queryValue: String,
        @Query("page") resultPage : Int
    ) : Response<PixabayResponse>
}