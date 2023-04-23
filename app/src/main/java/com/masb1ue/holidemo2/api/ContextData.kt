package com.masb1ue.holidemo2.api

import com.google.gson.annotations.SerializedName

data class ContextData(
    @SerializedName("page")
    val page: Int,
    @SerializedName("page_size")
    val page_size: Int,
    @SerializedName("total_rows")
    val total_rows: Int,
)
