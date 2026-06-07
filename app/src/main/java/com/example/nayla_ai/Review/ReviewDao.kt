package com.example.nayla_ai.Review

import androidx.room.*

@Dao
interface ReviewDao {
    @Query("SELECT * FROM reviews ORDER BY id DESC")
    suspend fun getAllReviews(): List<ReviewModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(review: ReviewModel)

    @Delete
    suspend fun delete(review: ReviewModel)
}