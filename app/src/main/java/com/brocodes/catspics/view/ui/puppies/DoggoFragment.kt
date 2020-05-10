package com.brocodes.catspics.view.ui.puppies

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
import com.brocodes.catspics.databinding.FragmentDoggoBinding
import com.brocodes.catspics.di.DaggerAppComponent
import com.brocodes.catspics.di.PetTypeModule
import com.brocodes.catspics.view.utils.CutePawsPagingAdapter
import com.brocodes.catspics.viewmodel.CutePawViewModel
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class DoggoFragment : Fragment() {

    @Inject
    lateinit var doggoViewModel: CutePawViewModel

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


        doggoViewModel.cutePawsLiveData.observe(viewLifecycleOwner, Observer {
            cutePawsPagingAdapter.submitList(it)
        })

        // Inflate the layout for this fragment
        return doggoFragmentBinding.root
    }

    @Suppress("DEPRACATED")
    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerAppComponent
            .builder()
            .petTypeModule(PetTypeModule("Puppies"))
            .build()
            .inject(this)
    }
}
