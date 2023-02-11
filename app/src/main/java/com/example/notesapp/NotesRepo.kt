package com.example.notesapp

import androidx.lifecycle.LiveData

class NotesRepo(private val notedao:NoteDao) {

    val allNotes:LiveData<List<Note>> = notedao.getAllNotes()

    suspend fun insertNote(note:Note)
    {
        notedao.insertNote(note)
    }

    suspend fun deleteNote(note:Note)
    {
        notedao.deletenote(note)
    }

//    suspend fun updateNote(noteText:String,noteId:Int)
//    {
//        notedao.updatenote(noteText,noteId)
//    }

}