package com.brocodes.catspics.di

import com.brocodes.catspics.data.PixabayMethods
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideRetrofitService(): PixabayMethods {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PixabayMethods::class.java)
    }

    companion object {
        const val BASE_URL = "https://pixabay.com/"
    }


}