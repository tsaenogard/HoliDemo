package com.masb1ue.holidemo2.api

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masb1ue.holidemo2.data.SampleData
import kotlinx.coroutines.*

class SearchViewModel : ViewModel() {
    var productResponse: List<com.masb1ue.holidemo2.data.Product> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    var isLoading :Boolean by mutableStateOf(false)
    var industryList: List<String> by mutableStateOf(SampleData.industryList)
    var usageList: List<String> by mutableStateOf(SampleData.usageList)

    fun getProductList() {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading = true
            val apiService = ApiService.getInstance()
            try {
                val allList = listOf(
                    Category(categoryID = 0, content = industryList),
                    Category(categoryID = 1, content = usageList)
                )
                val response = apiService.search(
                    SearchRequest(condition = allList, page = 0, pageSize = 30)
                )
                productResponse = response.list.map {
                    com.masb1ue.holidemo2.data.Product(
                        id = it.id,
                        priority = it.priority,
                        subtitle = it.subtitle,
                        name = it.name,
                        content = it.detail.content,
                        cost = it.detail.cost,
                        size = it.detail.size,
                        style = it.detail.style,
                        category = it.category,
                        imageData = it.imageData
                    )
                }
                isLoading = false
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                isLoading = false
                Log.d("testtest", "errorMessage = $errorMessage")
            }
        }
    }

    fun setIndustry(industry: String) {
        val tempIndustryList = if (industry == "全部") {
            SampleData.industryList.toList()
        } else if (industryList.size == SampleData.industryList.size) {
            listOf(industry)
        } else if (industryList.contains(industry)) {
            industryList.toMutableList().apply { remove(industry) }

        } else {
            industryList.toMutableList().apply { add(industry) }
        }
        industryList = tempIndustryList
    }

    fun setUsage(usage: String) {
        val tempUsageList = if (usage == "全部") {
            SampleData.usageList.toList()
        } else if (usageList.size == SampleData.usageList.size) {
            listOf(usage)
        } else if (usageList.contains(usage)) {
            usageList.toMutableList().apply { remove(usage) }

        } else {
            usageList.toMutableList().apply { add(usage) }
        }
        usageList = tempUsageList
    }
}