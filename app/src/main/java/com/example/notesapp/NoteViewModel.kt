package com.example.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application){

    val allNotes: LiveData<List<Note>>
    val repository:NotesRepo

    init{
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NotesRepo(dao)
        allNotes=repository.allNotes
    }

    fun deletenote(note:Note)=viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNote(note)
    }

    fun insertnote(note:Note)=viewModelScope.launch(Dispatchers.IO) {
        repository.insertNote(note)
    }
}