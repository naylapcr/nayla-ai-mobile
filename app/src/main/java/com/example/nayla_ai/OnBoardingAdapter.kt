package com.example.nayla_ai

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R

class OnboardingAdapter(
    private val onStartClick: () -> Unit
) : RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    private val titles = listOf("Selamat Datang", "Manajemen Inventaris", "Integrasi Berita")
    private val descriptions = listOf("Ini adalah aplikasi Bina Desa", "Kelola asetmu dengan mudah", "Pantau berita secara real-time")

    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val description: TextView = view.findViewById(R.id.tvDescription)
        val btnStart: Button = view.findViewById(R.id.btnAyoMulai)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false) // Pastikan file layout ini ada
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {

        holder.title.text = titles[position]
        holder.description.text = descriptions[position]

        if (position == titles.size - 1) {
            holder.btnStart.visibility = View.VISIBLE
            holder.btnStart.setOnClickListener { onStartClick() }
        } else {
            holder.btnStart.visibility = View.GONE
        }
    }

    override fun getItemCount() = titles.size
}