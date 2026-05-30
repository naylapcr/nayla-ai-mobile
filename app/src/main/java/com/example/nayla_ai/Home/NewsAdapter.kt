package com.example.nayla_ai.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nayla_ai.databinding.ItemNewsBinding

class NewsAdapter(private val newsList: List<BeritaDesaResponse>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.binding.tvNewsTitle.text = news.title ?:"Tanpa Judul"
        holder.binding.tvNewsDesc.text = news.body ?: "Tanpa Deskripsi"

        // Mengunduh gambar secara asinkronus menggunakan Glide
        Glide.with(holder.itemView.context)
            .load("https://picsum.photos/200/200?random=$position") // Gambar random biar gak kosong
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.binding.ivNewsThumb)
    }

    override fun getItemCount(): Int = newsList.size
}