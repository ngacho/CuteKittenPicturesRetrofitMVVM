package com.brocodes.catspics.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.brocodes.catspics.R
import com.bumptech.glide.Glide

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