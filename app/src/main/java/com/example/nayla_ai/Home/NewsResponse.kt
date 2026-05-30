package com.example.nayla_ai.home

import com.google.gson.annotations.SerializedName

data class ReqresResponse(
    @SerializedName("data")
    val data: List<NewsResponse>? = null
)

data class NewsResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("first_name")
    val title: String?,

    @SerializedName("email")
    val body: String?,

    @SerializedName("avatar")
    val image: String?
)