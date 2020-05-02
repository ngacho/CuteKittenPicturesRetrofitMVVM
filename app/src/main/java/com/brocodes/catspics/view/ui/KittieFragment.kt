package com.brocodes.catspics.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.FragmentKittieBinding
import com.brocodes.catspics.di.AppContainer
import com.brocodes.catspics.view.utils.EndlessScrollListener
import com.brocodes.catspics.view.utils.CutePawsRecyclerViewAdapter



class KittieFragment : Fragment() {

    private lateinit var cutePawsRecyclerViewAdapter: CutePawsRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val kittenFragmentBinding : FragmentKittieBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_kittie,
            container,
            false
        )

        val kittenRecyclerView = kittenFragmentBinding.kittenRecyclerview
        val kittenLayoutManager = LinearLayoutManager(context)
        kittenRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = kittenLayoutManager
        }

        val appContainer = AppContainer(this)

        val kittenViewModel = appContainer.kittenViewModel
        kittenViewModel.getCutePaws("kittens").observe(this, Observer {
            cutePawsRecyclerViewAdapter =
                CutePawsRecyclerViewAdapter(it)
            kittenRecyclerView.adapter = cutePawsRecyclerViewAdapter
        })

        kittenRecyclerView.addOnScrollListener(object : EndlessScrollListener(kittenLayoutManager){
            override fun loadMore(pageNumber: Int, recyclerView: RecyclerView) {
                kittenViewModel.loadMoreCutePaws("kittens", pageNumber)
                //cutePawsRecyclerViewAdapter.notifyDataSetChanged()
            }
        })



        // Inflate the layout for this fragment
        return kittenFragmentBinding.root
    }
}
