package com.example.nayla_ai.note

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nayla_ai.R
import com.example.nayla_ai.viewmodel.NoteViewModel

class NoteFormFragment : Fragment(R.layout.fragment_note_form) {

    private val viewModel: NoteViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etTitle = view.findViewById<EditText>(R.id.etTitle)
        val etContent = view.findViewById<EditText>(R.id.etContent)

        view.findViewById<Button>(R.id.btnSave).setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isNotEmpty()) {
                viewModel.addNote(title, content)
                parentFragmentManager.popBackStack()
            } else {
                etTitle.error = "Title tidak boleh kosong"
            }
        }
    }
}