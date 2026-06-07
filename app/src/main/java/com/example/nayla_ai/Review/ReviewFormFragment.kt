package com.example.nayla_ai.Review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.nayla_ai.R
import com.example.nayla_ai.data.AppDatabase
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReviewFormFragment : Fragment() {

    private lateinit var database: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = AppDatabase.getDatabase(requireContext())

        val etName = view.findViewById<TextInputEditText>(R.id.etReviewerName)
        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBarInput)
        val etReview = view.findViewById<TextInputEditText>(R.id.etReviewContent)
        val btnSave = view.findViewById<Button>(R.id.btnSaveReview)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val rating = ratingBar.rating
            val reviewText = etReview.text.toString().trim()

            if (name.isEmpty()) {
                etName.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }

            if (reviewText.isEmpty()) {
                etReview.error = "Review tidak boleh kosong"
                return@setOnClickListener
            }

            saveReview(name, rating, reviewText)
        }
    }

    private fun saveReview(name: String, rating: Float, review: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            val newReview = ReviewModel(name = name, rating = rating, review = review)
            database.reviewDao().insert(newReview)

            withContext(Dispatchers.Main) {
                Toast.makeText(context, "Review berhasil disimpan", Toast.LENGTH_SHORT).show()
                parentFragmentManager.popBackStack()
            }
        }
    }
}