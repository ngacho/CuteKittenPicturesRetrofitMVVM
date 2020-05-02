package com.brocodes.catspics.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.brocodes.catspics.data.CutePawsRepository
import com.brocodes.catspics.data.PixabayMethods
import com.brocodes.catspics.viewmodel.CutePawViewModel
import com.brocodes.catspics.viewmodelfactory.CutePawModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(viewModelStoreOwner: ViewModelStoreOwner) {


    private val pixabayMethods = Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PixabayMethods::class.java)

    private val catRepository =
        CutePawsRepository(pixabayMethods)

    private val viewModelFactory = CutePawModelFactory(catRepository)

    val kittenViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory).get(CutePawViewModel::class.java)
}