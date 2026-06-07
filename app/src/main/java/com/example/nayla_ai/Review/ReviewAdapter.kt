package com.example.nayla_ai.Review

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R

class ReviewAdapter(
    private var listReview: List<ReviewModel>,
    private val onDeleteClick: (ReviewModel) -> Unit
) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvReviewerName)
        val ratingBar: RatingBar = view.findViewById(R.id.ratingBar)
        val tvContent: TextView = view.findViewById(R.id.tvReviewContent)
        val btnDelete: ImageView = view.findViewById(R.id.btnDeleteReview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listReview[position]
        holder.tvName.text = data.name
        holder.ratingBar.rating = data.rating
        holder.tvContent.text = data.review

        holder.btnDelete.setOnClickListener {
            onDeleteClick(data)
        }
    }

    override fun getItemCount(): Int = listReview.size

    fun updateData(newList: List<ReviewModel>) {
        listReview = newList
        notifyDataSetChanged()
    }
}