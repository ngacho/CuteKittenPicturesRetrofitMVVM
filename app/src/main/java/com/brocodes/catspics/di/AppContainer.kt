package com.brocodes.catspics.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.brocodes.catspics.model.CatRepository
import com.brocodes.catspics.model.PixabayMethods
import com.brocodes.catspics.viewmodel.KittenViewModel
import com.brocodes.catspics.viewmodelfactory.KittenViewModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(viewModelStoreOwner: ViewModelStoreOwner) {


    private val pixabayMethods = Retrofit.Builder()
        .baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PixabayMethods::class.java)

    private val catRepository = CatRepository(pixabayMethods)

    private val viewModelFactory = KittenViewModelFactory(catRepository)

    val kittenViewModel = ViewModelProvider(viewModelStoreOwner, viewModelFactory).get(KittenViewModel::class.java)
}