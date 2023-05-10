package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categoryID")
    val categoryID: Int,
    @SerializedName("content")
    val content: String
)
