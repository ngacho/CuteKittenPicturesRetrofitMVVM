package com.brocodes.catspics.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.brocodes.catspics.data.CutePawsRepository
import com.brocodes.catspics.viewmodel.CutePawViewModel

class CutePawModelFactory(private val cutePawsRepository: CutePawsRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CutePawViewModel(cutePawsRepository) as T
    }
}