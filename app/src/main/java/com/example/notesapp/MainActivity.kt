package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesAdapter {
    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager=LinearLayoutManager(this)
        val adapter=NotesAdapter(this,this)

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list->
            list?.let{
                adapter.updateList(it)
            }
        })
    }

    override fun OnItemClick(note: Note) {
        viewModel.deletenote(note)
        Toast.makeText(this,"${note.note} Deleted",Toast.LENGTH_SHORT).show()
    }

    fun submitData(view: View) {
        val inputtext=findViewById<EditText>(R.id.noteText)
        val noteText=inputtext.text.toString()
        if(noteText.isNotEmpty())
        {
            viewModel.insertnote(Note(noteText))
            Toast.makeText(this,"${noteText} Inserted",Toast.LENGTH_SHORT).show()
        }
    }
}