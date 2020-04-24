package com.brocodes.catspics.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brocodes.catspics.R
import com.brocodes.catspics.model.ImageItem
import com.bumptech.glide.Glide

class KittenRecyclerViewAdapter(private val kittensList: List<ImageItem>) : RecyclerView.Adapter<KittenRecyclerViewAdapter.KittenViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KittenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kitten_item, parent, false)
        return KittenViewHolder(view)
    }

    override fun getItemCount() = kittensList.size

    override fun onBindViewHolder(holder: KittenViewHolder, position: Int) {
        holder.bind(kittensList[position])
    }

    class KittenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val kittenPicImageView: ImageView = view.findViewById(R.id.kitten_image)
        private val likesTextView: TextView = view.findViewById(R.id.kitten_likes_textview)
        private val ownerImageView: ImageView = view.findViewById(R.id.owner_image_holder)
        private val ownerNameTextView: TextView = view.findViewById(R.id.owner_name_textview)

        fun bind(imageItem: ImageItem){

            Glide.with(itemView.context)
                .load(imageItem.largeImageURL)
                .timeout(5000)
                .into(kittenPicImageView)

            likesTextView.text = imageItem.likes.toString()

            Glide.with(itemView.context)
                .load(imageItem.userImageUrl)
                .override(30, 30)
                .fallback(R.drawable.ic_person_pin)
                .into(ownerImageView)

            ownerNameTextView.text = imageItem.user
        }
    }
}


