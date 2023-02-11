package com.example.notesapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("Select * from note_table order by NoteId ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note:Note)

    @Delete
    suspend fun deletenote(note:Note)

//    @Query("Update note_table set Note_Text=:updatedNoteText where Note_Id=:id")
//    suspend fun updatenote(updatedNoteText:String, id:Int)

}