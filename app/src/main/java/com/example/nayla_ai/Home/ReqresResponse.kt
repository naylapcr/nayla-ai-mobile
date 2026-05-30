package com.example.nayla_ai.Home

import com.google.gson.annotations.SerializedName

data class ReqresResponse(
    @SerializedName("data")
    val data: List<BeritaDesaResponse>? = null
)