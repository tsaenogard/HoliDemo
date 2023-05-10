package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class ImageData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
)
