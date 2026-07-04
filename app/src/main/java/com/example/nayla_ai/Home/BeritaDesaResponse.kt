package com.example.nayla_ai.Home

import com.google.gson.annotations.SerializedName

data class BeritaDesaResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("body")
    val body: String?
)