package com.brocodes.catspics.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.FragmentDoggoBinding
import com.brocodes.catspics.di.AppContainer
import com.brocodes.catspics.view.utils.CutePawsRecyclerViewAdapter
import com.brocodes.catspics.view.utils.EndlessScrollListener

/**
 * A simple [Fragment] subclass.
 */
class DoggoFragment : Fragment() {

    private lateinit var cutePawsRecyclerViewAdapter: CutePawsRecyclerViewAdapter

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

        val doggoRecyclerView = doggoFragmentBinding.puppyRecyclerview
        val doggoLayoutManager = LinearLayoutManager(context)
        doggoRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = doggoLayoutManager
        }

        val appContainer = AppContainer(this)

        val kittenViewModel = appContainer.kittenViewModel
        kittenViewModel.getCutePaws("puppies").observe(this, Observer {
            cutePawsRecyclerViewAdapter =
                CutePawsRecyclerViewAdapter(it)
            doggoRecyclerView.adapter = cutePawsRecyclerViewAdapter
        })

        doggoRecyclerView.addOnScrollListener(object : EndlessScrollListener(doggoLayoutManager){
            override fun loadMore(pageNumber: Int, recyclerView: RecyclerView) {
                kittenViewModel.loadMoreCutePaws("puppies", pageNumber)
                //cutePawsRecyclerViewAdapter.notifyDataSetChanged()
            }
        })




        // Inflate the layout for this fragment
        return doggoFragmentBinding.root
    }

}
