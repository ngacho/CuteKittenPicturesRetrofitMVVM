package com.brocodes.catspics.viewmodel



import androidx.lifecycle.ViewModel
import com.brocodes.catspics.data.CatRepository


class KittenViewModel(private val catRepository: CatRepository) : ViewModel() {

    fun getKittens() = catRepository.loadKittens()

    fun loadMoreKittens(resultPage : Int) = catRepository.loadMoreKittens(resultPage)


}

