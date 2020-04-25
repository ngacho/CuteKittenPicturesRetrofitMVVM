package com.brocodes.catspics.data

import com.brocodes.catspics.model.PixabayMethods
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

class RetrofitBuilder {

    private val client = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(50, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val pixabayAccessApi: PixabayMethods = retrofit.create(PixabayMethods::class.java)
}