package com.brocodes.catspics.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brocodes.catspics.model.CatRepository
import com.brocodes.catspics.viewmodel.KittenViewModel

class KittenViewModelFactory(private val catRepository: CatRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return KittenViewModel(catRepository) as T
    }
}