package com.example.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val context:Context,val listener:INotesAdapter):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    val allnote = ArrayList<Note>()

    inner class NotesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textview = itemView.findViewById<TextView>(R.id.text)
        val deletebutton = itemView.findViewById<ImageView>(R.id.deleteicon)
        val updatebutton = itemView.findViewById<ImageView>(R.id.updateicon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_item,parent,false)
        val viewHolder = NotesViewHolder(view)

        viewHolder.deletebutton.setOnClickListener{
            listener.OnItemClick(allnote[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allnote.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentnode=allnote[position]
        holder.textview.text=currentnode.note
    }

    fun updateList(newlist:List<Note>)
    {
        allnote.clear()
        allnote.addAll(newlist)

        notifyDataSetChanged()
    }

}

interface INotesAdapter
{
    fun OnItemClick(note:Note)
}