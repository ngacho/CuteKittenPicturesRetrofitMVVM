package com.brocodes.catspics.view.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.brocodes.catspics.constants.PawIdentifiers
import com.brocodes.catspics.view.ui.puppies.DoggoFragment
import com.brocodes.catspics.view.ui.kittens.KittieFragment
import java.lang.IllegalStateException

@Suppress("deprecation")
class ViewPagerAdapter(supportFragmentManager: FragmentManager): FragmentStatePagerAdapter(supportFragmentManager) {


    override fun getItem(position: Int): Fragment = when(position){
        0 -> KittieFragment()
        1 -> DoggoFragment()
        else -> throw IllegalStateException("Unexpected position $position")
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int): CharSequence = when(position){
        0 -> PawIdentifiers.KITTIE
        1 -> PawIdentifiers.DOGGO
        else -> throw IllegalStateException("Unexpected position $position")
    }


}