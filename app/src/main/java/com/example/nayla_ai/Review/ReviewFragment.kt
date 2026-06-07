package com.example.nayla_ai.Review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R
import com.example.nayla_ai.data.AppDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReviewFragment : Fragment() {

    private lateinit var database: AppDatabase
    private lateinit var rvReview: RecyclerView
    private lateinit var adapter: ReviewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = AppDatabase.getDatabase(requireContext())
        rvReview = view.findViewById(R.id.rvReview)
        rvReview.layoutManager = LinearLayoutManager(context)

        loadData()

        view.findViewById<FloatingActionButton>(R.id.fabAddReview).setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, ReviewFormFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun loadData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val listReview = database.reviewDao().getAllReviews()
            withContext(Dispatchers.Main) {
                adapter = ReviewAdapter(listReview) { review ->
                    deleteReview(review)
                }
                rvReview.adapter = adapter
            }
        }
    }

    private fun deleteReview(review: ReviewModel) {
        lifecycleScope.launch(Dispatchers.IO) {
            database.reviewDao().delete(review)
            val updatedList = database.reviewDao().getAllReviews()
            withContext(Dispatchers.Main) {
                adapter.updateData(updatedList)
                Toast.makeText(context, "Review dihapus", Toast.LENGTH_SHORT).show()
            }
        }
    }
}