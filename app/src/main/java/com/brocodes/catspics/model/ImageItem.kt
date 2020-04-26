package com.brocodes.catspics.model

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.brocodes.catspics.R
import com.bumptech.glide.Glide


data class ImageItem(val id: Long, val pageUrl: String, val type: String, val tags: String,
                     val previewUrl: String, val previewWidth: Int, val previewHeight: Int,
                     val webformatUrl: String, val webformatWidth: Int, val webformatheight: Int,
                     val largeImageURL: String, val imageWidth : Int, val imageHeight: Int,
                     val imageSize: Int, val views: Long, val downloads: Long, val likes: Int,
                     val comments: Int, val user_id: Long, val user: String, val userImageUrl: String){}

@BindingAdapter("catImage")
fun loadCatImage(catImageView: ImageView, catImagePath: String){
    Glide.with(catImageView.context)
        .load(catImagePath)
        .timeout(5000)
        .into(catImageView)
}

@BindingAdapter("profileImage")
fun loadProfileImage(userImageView: ImageView, userImagePath: String?){
    Glide.with(userImageView.context)
        .load(userImagePath)
        .override(30, 30)
        .fallback(R.drawable.ic_person_pin)
        .into(userImageView)
}

@BindingAdapter("likesString")
fun convertLikesToString(likesTextView: TextView, likes: Int) = likes.toString()