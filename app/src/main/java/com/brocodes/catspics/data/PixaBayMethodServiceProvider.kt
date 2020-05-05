package com.brocodes.catspics.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun providePixaBayMethodService() : PixabayMethods{
    return Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PixabayMethods::class.java)
}

