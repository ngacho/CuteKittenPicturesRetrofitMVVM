package com.brocodes.catspics.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brocodes.catspics.data.PixabayMethods
import com.brocodes.catspics.viewmodel.CutePawViewModel

class CutePawModelFactory(private val pixabayMethods: PixabayMethods, private val petType : String) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CutePawViewModel(pixabayMethods, petType) as T
    }
}