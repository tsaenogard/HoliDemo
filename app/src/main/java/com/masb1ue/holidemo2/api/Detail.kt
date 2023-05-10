package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("content")
    val content: String,
    @SerializedName("cost")
    val cost: String,
    @SerializedName("size")
    val size: String,
    @SerializedName("style")
    val style: String,
)