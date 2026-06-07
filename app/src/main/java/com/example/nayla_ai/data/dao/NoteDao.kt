package com.example.nayla_ai.data.dao

import androidx.room.*
import com.example.nayla_ai.data.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): Flow<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)
}