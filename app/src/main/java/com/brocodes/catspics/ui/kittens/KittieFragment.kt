package com.brocodes.catspics.ui.kittens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.FragmentKittieBinding
import com.brocodes.catspics.di.DaggerAppComponent
import com.brocodes.catspics.di.PetTypeModule
import com.brocodes.catspics.view.utils.CutePawsPagingAdapter
import com.brocodes.catspics.ui.CutePawViewModel
import javax.inject.Inject


class KittieFragment : Fragment() {

    @Inject lateinit var viewModel: CutePawViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val kittenFragmentBinding: FragmentKittieBinding = DataBindingUtil.inflate(
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

        viewModel.cutePawsLiveData.observe(viewLifecycleOwner, Observer {
            cutePawsPagingAdapter.submitList(it)
        })

        // Inflate the layout for this fragment
        return kittenFragmentBinding.root
    }

    @Suppress("DEPRECATED")
    override fun onAttach(context: Context) {
        super.onAttach(context)


        DaggerAppComponent.builder()
            .petTypeModule(PetTypeModule("Kitten"))
            .build().inject(this)
    }
}
