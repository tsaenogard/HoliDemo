package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("id")
    val code: Int,
    @SerializedName("context")
    val contextData: ContextData,
    @SerializedName("list")
    val list: List<Product>,
)