package com.brocodes.catspics.viewmodel



import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.brocodes.catspics.model.CatRepository
import com.brocodes.catspics.model.ImageItem


class KittenViewModel(private val catRepository: CatRepository) : ViewModel() {

    fun getKittens(): LiveData<List<ImageItem>> {
        return catRepository.loadKittens()
    }


}

