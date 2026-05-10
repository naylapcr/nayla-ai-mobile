package com.example.nayla_ai.Message

data class MessageModel(
    val id: Int,
    val senderName: String,
    val messageContent: String,
    val time: String,
    val imageProfile: Int // Menggunakan resource ID (R.drawable...)
)