package com.masb1ue.holidemo2.data

import com.masb1ue.holidemo2.api.CategoryResponse
import com.masb1ue.holidemo2.api.ImageData

data class Product(
    val id: Int,
    val priority: Int,
    val subtitle: String,
    val name: String,
    val content: String,
    val cost: String,
    val size: String,
    val style: String,
    val category: List<CategoryResponse>,
    val imageData: List<ImageData>,
)
