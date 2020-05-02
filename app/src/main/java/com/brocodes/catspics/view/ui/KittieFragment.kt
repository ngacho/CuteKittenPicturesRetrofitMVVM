package com.brocodes.catspics.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.FragmentKittieBinding


class KittieFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val kittenFragmentBinding : FragmentKittieBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_kittie,
            container,
            false
        )
        val view = kittenFragmentBinding.root



        // Inflate the layout for this fragment
        return view
    }
}
