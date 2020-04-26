package com.brocodes.catspics.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.data.CatRetrofitClient
import com.brocodes.catspics.model.CatRepository
import com.brocodes.catspics.viewmodel.KittenViewModel
import com.brocodes.catspics.viewmodelfactory.KittenViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var kittenRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kittenRecyclerView = findViewById(R.id.kitten_recyclerview)
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
