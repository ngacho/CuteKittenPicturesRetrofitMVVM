package com.brocodes.catspics.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.databinding.KittenItemBinding
import com.brocodes.catspics.model.ImageItem


class KittenRecyclerViewAdapter(private val kittensList: List<ImageItem>) : RecyclerView.Adapter<KittenRecyclerViewAdapter.KittenViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KittenViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<KittenItemBinding>(inflater, R.layout.kitten_item, parent, false)
        return KittenViewHolder(binding)
    }

    override fun getItemCount() = if (kittensList.isEmpty()) 0 else kittensList.size

    override fun onBindViewHolder(holder: KittenViewHolder, position: Int) {
        holder.bind(kittensList[position])
    }

    class KittenViewHolder(private val kittenItemBinding: KittenItemBinding) : RecyclerView.ViewHolder(kittenItemBinding.root) {

        fun bind(imageItem: ImageItem){
            kittenItemBinding.imageItem = imageItem
            kittenItemBinding.executePendingBindings()
        }
    }
}


