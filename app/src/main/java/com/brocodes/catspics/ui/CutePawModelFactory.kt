package com.brocodes.catspics.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brocodes.catspics.data.PixabayMethods
import javax.inject.Inject

class CutePawModelFactory @Inject constructor(private val pixabayMethods: PixabayMethods, private val petType : String) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CutePawViewModel(
            pixabayMethods,
            petType
        ) as T
    }
}