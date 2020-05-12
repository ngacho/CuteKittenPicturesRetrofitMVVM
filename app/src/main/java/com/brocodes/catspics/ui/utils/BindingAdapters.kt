package com.brocodes.catspics.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.brocodes.catspics.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("catImage")
fun loadCatImage(catImageView: ImageView, catImagePath: String){
    Glide.with(catImageView.context)
        .load(catImagePath)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
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