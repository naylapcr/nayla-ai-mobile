package com.example.nayla_ai.note

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R
import com.example.nayla_ai.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class NoteFragment : Fragment(R.layout.fragment_note) {

    private val viewModel: NoteViewModel by viewModels()
    private lateinit var adapter: NoteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NoteAdapter { note -> viewModel.deleteNote(note) }

        view.findViewById<RecyclerView>(R.id.rvNotes).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@NoteFragment.adapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.notes.collect { notes ->
                adapter.submitList(notes)
            }
        }

        view.findViewById<FloatingActionButton>(R.id.fabAddNote).setOnClickListener {
            // Jika Anda tidak menggunakan Navigation Component, Anda bisa memanggil fungsi di Activity
            // Tapi karena Anda ingin ke form, kita ganti fragmentnya
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, NoteFormFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
