package com.brocodes.catspics.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brocodes.catspics.data.RetrofitBuilder
import com.brocodes.catspics.viewmodel.KittenViewModel

class KittenViewModelFactory(private val retrofitBuilder: RetrofitBuilder) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KittenViewModel(retrofitBuilder) as T
    }
}