package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: Int,
    @SerializedName("priority")
    val priority: Int,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("detail")
    val detail: Detail,
    @SerializedName("category")
    val category: List<CategoryResponse>,
    @SerializedName("image")
    val imageData: List<ImageData>,
)