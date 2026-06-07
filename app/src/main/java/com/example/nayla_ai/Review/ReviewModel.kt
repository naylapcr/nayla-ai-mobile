package com.example.nayla_ai.Review

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reviews")
data class ReviewModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val rating: Float,
    val review: String
)