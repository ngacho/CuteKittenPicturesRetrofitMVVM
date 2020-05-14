package com.brocodes.catspics.data

import com.brocodes.catspics.constants.PawIdentifiers
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayMethods {

    @GET("/api/")
    suspend fun getPaws(
        @Query("key") key: String = PawIdentifiers.API_KEY,
        @Query("q") queryValue: String
    ): Response<PixabayResponse>

    @GET("/api/")
    suspend fun loadMorePaws(
        @Query("key") key: String = PawIdentifiers.API_KEY,
        @Query("q") queryValue: String,
        @Query("page") resultPage : Int
    ) : Response<PixabayResponse>
}