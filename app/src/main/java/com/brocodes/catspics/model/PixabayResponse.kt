package com.brocodes.catspics.model

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