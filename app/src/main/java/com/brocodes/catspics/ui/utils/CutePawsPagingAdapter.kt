package com.brocodes.catspics.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.data.ImageItem
import com.brocodes.catspics.databinding.KittenItemBinding

class CutePawsPagingAdapter :
    PagedListAdapter<ImageItem, CutePawsPagingAdapter.ImageItemViewHolder>(IMAGE_COMPARATOR) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder = create(parent)

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        val imageItem = getItem(position)
        if (imageItem != null) {
            (holder).bind(imageItem)
        }
    }

    class ImageItemViewHolder(private val kittenItemBinding: KittenItemBinding) : RecyclerView.ViewHolder(kittenItemBinding.root) {

        fun bind(imageItem: ImageItem){
            kittenItemBinding.imageItem = imageItem
            kittenItemBinding.executePendingBindings()
        }
    }

    companion object {
        private val IMAGE_COMPARATOR = object : DiffUtil.ItemCallback<ImageItem>() {
            override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean =
                newItem == oldItem
        }
        fun create(viewGroup: ViewGroup) : ImageItemViewHolder{
            //created here so we dont leak implementation details to the adapter
            val inflater = LayoutInflater.from(viewGroup.context)

            val cutePawsItemBinding = DataBindingUtil.inflate<KittenItemBinding>(
                inflater,
                R.layout.kitten_item,
                viewGroup,
                false
            )

            return ImageItemViewHolder(cutePawsItemBinding)
        }
    }
}