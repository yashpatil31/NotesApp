package com.example.notesapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(@ColumnInfo(name = "Note_Text")val note: String)
{
    @PrimaryKey(autoGenerate = true)var NoteId = 0
}