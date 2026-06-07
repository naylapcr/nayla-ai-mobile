package com.example.nayla_ai.Message

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "message_table")
data class MessageModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sender: String,
    val content: String
)