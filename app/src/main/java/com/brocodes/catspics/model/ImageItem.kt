package com.brocodes.catspics.model


data class ImageItem(val id: Long, val pageUrl: String, val type: String, val tags: String,
                     val previewUrl: String, val previewWidth: Int, val previewHeight: Int,
                     val webformatUrl: String, val webformatWidth: Int, val webformatheight: Int,
                     val largeImageURL: String, val imageWidth : Int, val imageHeight: Int,
                     val imageSize: Int, val views: Long, val downloads: Long, val likes: Int,
                     val comments: Int, val user_id: Long, val user: String, val userImageUrl: String)