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
        
        // Buat judul lebih bertema desa jika data dari API terlalu generic
        val displayTitle = news.title?.let { 
            if (it.length > 20) "Info Desa: ${it.take(30)}..." else "Kabar Desa: $it"
        } ?: "Tanpa Judul"
        
        holder.binding.tvNewsTitle.text = displayTitle
        holder.binding.tvNewsDesc.text = news.body ?: "Klik untuk membaca detail berita selengkapnya..."

        Glide.with(holder.itemView.context)
            .load("https://picsum.photos/400/300?nature,village&sig=$position") // Gambar bertema alam/desa
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.stat_notify_error)
            .into(holder.binding.ivNewsThumb)
    }


    override fun getItemCount(): Int = newsList.size
}