package com.brocodes.catspics.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.brocodes.catspics.R
import com.brocodes.catspics.constants.PawIdentifiers
import com.brocodes.catspics.data.providePixaBayMethodService
import com.brocodes.catspics.databinding.FragmentKittieBinding
import com.brocodes.catspics.view.utils.CutePawsPagingAdapter
import com.brocodes.catspics.viewmodel.CutePawViewModel
import com.brocodes.catspics.viewmodelfactory.CutePawModelFactory


class KittieFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val kittenFragmentBinding : FragmentKittieBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_kittie,
            container,
            false
        )



        val cutePawsPagingAdapter = CutePawsPagingAdapter()

        val kittenRecyclerView = kittenFragmentBinding.kittenRecyclerview
        val doggoLayoutManager = LinearLayoutManager(context)
        kittenRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = doggoLayoutManager
            adapter = cutePawsPagingAdapter

        }

        val pixabayMethods = providePixaBayMethodService()

        val viewModel = ViewModelProvider(viewModelStore, CutePawModelFactory(pixabayMethods, PawIdentifiers.KITTENS))
            .get(CutePawViewModel::class.java)
        viewModel.cutePawsLiveData.observe(viewLifecycleOwner, Observer {
            cutePawsPagingAdapter.submitList(it)
        })

        // Inflate the layout for this fragment
        return kittenFragmentBinding.root
    }

}
