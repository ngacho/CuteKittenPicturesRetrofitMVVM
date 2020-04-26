package com.brocodes.catspics.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.data.CatRetrofitClient
import com.brocodes.catspics.databinding.ActivityMainBinding
import com.brocodes.catspics.model.CatRepository
import com.brocodes.catspics.viewmodel.KittenViewModel
import com.brocodes.catspics.viewmodelfactory.KittenViewModelFactory
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var kittenRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityDataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        kittenRecyclerView = mainActivityDataBinding.kittenRecyclerview
        kittenRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        val catRetrofitClient = CatRetrofitClient()
        val catRepository = CatRepository(catRetrofitClient)
        val viewModelFactory = KittenViewModelFactory(catRepository)

        val kittenViewModel = ViewModelProvider(this, viewModelFactory).get(KittenViewModel::class.java)
        kittenViewModel.getKittens().observe(this, Observer {
            kittenRecyclerView.adapter = KittenRecyclerViewAdapter(it)
        })

    }
}


