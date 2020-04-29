package com.brocodes.catspics.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.ActivityMainBinding
import com.brocodes.catspics.di.AppContainer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainActivityDataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val kittenRecyclerView = mainActivityDataBinding.kittenRecyclerview
        kittenRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
        }

        val appContainer = AppContainer(this)

        val kittenViewModel = appContainer.kittenViewModel
        kittenViewModel.getKittens().observe(this, Observer {
            kittenRecyclerView.adapter = KittenRecyclerViewAdapter(it)
        })

    }
}


