package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("content")
    val content: String,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("size")
    val size: String,
    @SerializedName("remark")
    val remark: String,
)