package com.example.nayla_ai.Home

import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {
    // API ini mengembalikan List<Post> secara langsung
    @GET("posts")
    fun getVillageNews(): Call<List<BeritaDesaResponse>>
}