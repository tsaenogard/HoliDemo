package com.masb1ue.holidemo2.api


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface ApiService {
    @Headers("Content-Type: application/json", "accept: application/json")
    @POST("api/v1/product/search/")
    suspend fun search(
        @Body searchRequest: SearchRequest
    ): SearchResponse

    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
                apiService = Retrofit.Builder()
                    .baseUrl("https://api.waproject-gift.store/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}