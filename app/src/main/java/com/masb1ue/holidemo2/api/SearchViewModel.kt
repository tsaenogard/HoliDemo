package com.masb1ue.holidemo2.api

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masb1ue.holidemo2.data.Product
import kotlinx.coroutines.*

class SearchViewModel : ViewModel() {
    var productResponse: List<Product> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getProductList(category: List<String>, usage: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            val apiService = ApiService.getInstance()
            try {
                val allList = listOf(
                    Category(categoryID = 0, content = category),
                    Category(categoryID = 1, content = usage)
                )
                val response = apiService.search(
                    SearchRequest(condition = allList, page = 0, pageSize = 30)
                )
                productResponse = response.list.map {
                    com.masb1ue.holidemo2.data.Product(
                        id = it.id,
                        subtitle = it.subtitle,
                        name = it.name,
                        detail = it.detail.content,
                        cost = it.detail.cost,
                        size = it.detail.size,
                        remark = it.detail.remark,
                        category1 = it.category[0].content,
                        category2 = it.category[1].content,
                        image = it.imageData.map { image -> image.url }
                    )
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                Log.d("testtest", "errorMessage = $errorMessage")
            }
        }
    }
}