package com.brocodes.catspics.model

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.brocodes.catspics.R
import com.bumptech.glide.Glide


data class ImageItem(val id: Long, val pageUrl: String, val type: String, val tags: String,
                     val previewUrl: String, val previewWidth: Int, val previewHeight: Int,
                     val webFormatUrl: String, val webFormatWidth: Int, val webFormatHeight: Int,
                     val largeImageURL: String, val imageWidth : Int, val imageHeight: Int,
                     val imageSize: Int, val views: Long, val downloads: Long, val likes: Int,
                     val comments: Int, val user_id: Long, val user: String, val userImageUrl: String){}
