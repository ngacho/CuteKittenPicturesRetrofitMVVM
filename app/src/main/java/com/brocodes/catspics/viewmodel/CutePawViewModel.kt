package com.brocodes.catspics.viewmodel



import androidx.lifecycle.ViewModel
import com.brocodes.catspics.data.CutePawsRepository


class CutePawViewModel(private val cutePawsRepository: CutePawsRepository) : ViewModel() {

    fun getCutePaws
                (petType : String) = cutePawsRepository.loadKittens(petType)

    fun loadMoreCutePaws
                (petType: String, resultPage : Int) = cutePawsRepository.loadMoreKittens(petType, resultPage)


}

