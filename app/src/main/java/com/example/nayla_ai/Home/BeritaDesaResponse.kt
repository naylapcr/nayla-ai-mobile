package com.example.nayla_ai.Home

import com.google.gson.annotations.SerializedName

data class BeritaDesaResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("first_name")
    val title: String?,

    @SerializedName("email")
    val body: String?,

    @SerializedName("avatar")
    val image: String?
)