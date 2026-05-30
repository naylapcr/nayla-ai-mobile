package com.example.nayla_ai.Home

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// 1. Interface untuk endpoint API
interface NewsApiService {
    @GET("posts") // Sesuaikan dengan endpoint yang kamu pakai
    fun getNews(): Call<List<BeritaDesaResponse>>

    // 2. Companion object untuk membuat instance
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val instance: NewsApiService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(NewsApiService::class.java)
        }
    }
}