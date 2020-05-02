package com.brocodes.catspics.data

import com.brocodes.catspics.data.ImageItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PixabayResponse(

    @SerializedName("total")
    @Expose
    var total: Long?,

    @SerializedName("totalHits")
    @Expose
    var totalHits: Long?,

    @SerializedName("hits")
    @Expose
    var hits: List<ImageItem>
)