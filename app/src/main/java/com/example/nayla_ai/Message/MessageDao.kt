package com.example.nayla_ai.Message

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao {
    @Query("SELECT * FROM message_table")
    fun getAllMessages(): List<MessageModel>

    @Insert
    fun insert(message: MessageModel)

    @Delete
    suspend fun delete(message: MessageModel) // Tambahkan ini
}