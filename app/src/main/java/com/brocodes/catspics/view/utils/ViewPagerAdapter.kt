package com.brocodes.catspics.view.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.brocodes.catspics.constants.PawIdentifiers
import com.brocodes.catspics.view.ui.DoggoFragment
import com.brocodes.catspics.view.ui.KittieFragment
import java.lang.IllegalStateException
import java.util.*

@Suppress("deprecation")
class ViewPagerAdapter(supportFragmentManager: FragmentManager): FragmentStatePagerAdapter(supportFragmentManager) {


    override fun getItem(position: Int): Fragment = when(position){
        0 -> KittieFragment()
        1 -> DoggoFragment()
        else -> throw IllegalStateException("Unexpected position $position")
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int): CharSequence = when(position){
        0 -> PawIdentifiers.DOGGO
        1 -> PawIdentifiers.KITTIE
        else -> throw IllegalStateException("Unexpected position $position")
    }


}