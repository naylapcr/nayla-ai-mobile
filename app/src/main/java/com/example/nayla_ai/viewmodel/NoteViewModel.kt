package com.example.nayla_ai.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.nayla_ai.data.AppDatabase
import com.example.nayla_ai.data.entity.Note
import com.example.nayla_ai.data.repository.NoteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = NoteRepository(AppDatabase.getDatabase(application))

    val notes = repo.getAllNotes()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            repo.insertNote(Note(title = title, content = content))
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch { repo.deleteNote(note) }
    }
}