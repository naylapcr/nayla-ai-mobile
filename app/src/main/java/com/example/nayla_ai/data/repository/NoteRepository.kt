package com.example.nayla_ai.data.repository

import com.example.nayla_ai.data.AppDatabase
import com.example.nayla_ai.data.entity.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val db: AppDatabase) {
    fun getAllNotes(): Flow<List<Note>> = db.noteDao().getAllNotes()
    suspend fun insertNote(note: Note) = db.noteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.noteDao().deleteNote(note)
}