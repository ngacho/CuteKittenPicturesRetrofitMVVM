package com.brocodes.catspics.view.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager

import com.brocodes.catspics.R
import com.brocodes.catspics.constants.PawIdentifiers
import com.brocodes.catspics.data.CutePawsDataSource
import com.brocodes.catspics.data.ImageItem
import com.brocodes.catspics.data.PixabayMethods
import com.brocodes.catspics.data.providePixaBayMethodService
import com.brocodes.catspics.databinding.FragmentDoggoBinding
import com.brocodes.catspics.view.utils.CutePawsPagingAdapter
import com.brocodes.catspics.viewmodel.CutePawViewModel
import com.brocodes.catspics.viewmodelfactory.CutePawModelFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        val cutePawsPagingAdapter = CutePawsPagingAdapter()

        val doggoRecyclerView = doggoFragmentBinding.puppyRecyclerview
        val doggoLayoutManager = LinearLayoutManager(context)
        doggoRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = doggoLayoutManager
            adapter = cutePawsPagingAdapter
        }

        val pixabayMethods = providePixaBayMethodService()

        val doggoViewModel = ViewModelProvider(viewModelStore, CutePawModelFactory(pixabayMethods, PawIdentifiers.PUPPIES))
            .get(CutePawViewModel::class.java)
        doggoViewModel.cutePawsLiveData.observe(viewLifecycleOwner, Observer {
            cutePawsPagingAdapter.submitList(it)
        })

        // Inflate the layout for this fragment
        return doggoFragmentBinding.root
    }





}
