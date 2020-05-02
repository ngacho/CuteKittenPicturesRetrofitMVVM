package com.brocodes.catspics.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.FragmentDoggoBinding

/**
 * A simple [Fragment] subclass.
 */
class DoggoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val doggoFragmentBinding: FragmentDoggoBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_doggo,
            container,
            false
        )
        val view = doggoFragmentBinding.root



        // Inflate the layout for this fragment
        return view
    }

}
