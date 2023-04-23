package com.masb1ue.holidemo2.api

import retrofit2.http.Query

data class SearchRequest(
    @Query("condition")
    val condition: List<Category>,
    @Query("page")
    val page: Int,
    @Query("pageSize")
    val pageSize: Int,
)