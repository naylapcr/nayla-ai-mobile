package com.example.nayla_ai.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.data.entity.Note
import com.example.nayla_ai.databinding.ItemNoteBinding


class NoteAdapter(
    private val onDelete: (Note) -> Unit
) : ListAdapter<Note, NoteAdapter.NoteViewHolder>(DiffCallback) {

    inner class NoteViewHolder(val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object DiffCallback : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(a: Note, b: Note) = a.id == b.id
        override fun areContentsTheSame(a: Note, b: Note) = a == b
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        holder.binding.tvTitle.text = note.title
        holder.binding.tvContent.text = note.content
        holder.binding.btnDelete.setOnClickListener { onDelete(note) }
    }
}