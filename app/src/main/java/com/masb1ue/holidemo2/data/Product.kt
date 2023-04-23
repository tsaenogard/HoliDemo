package com.masb1ue.holidemo2.data

data class Product(
    val id: Int,
    val subtitle: String,
    val name: String,
    val detail: String,
    val cost: Int,
    val size: String,
    val remark: String,
    val category1: String,
    val category2: String,
    val image: List<String>,
)
