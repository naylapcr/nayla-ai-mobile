package com.example.nayla_ai.Home.pertemuan_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nayla_ai.R

class SuratAdapter(
    private val listSurat: List<JenisSurat>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<SuratAdapter.SuratViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(surat: JenisSurat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuratViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_surat, parent, false)
        return SuratViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuratViewHolder, position: Int) {
        holder.bind(listSurat[position], listener)
    }

    override fun getItemCount(): Int = listSurat.size

    class SuratViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNamaSurat: TextView = itemView.findViewById(R.id.tvNamaSurat)
        private val tvDeskripsi: TextView = itemView.findViewById(R.id.tvDeskripsiSurat)
        private val imgItem: ImageView = itemView.findViewById(R.id.imgItem)

        fun bind(surat: JenisSurat, listener: OnItemClickListener) {
            tvNamaSurat.text = surat.namaSurat
            tvDeskripsi.text = surat.deskripsi

            // Menggunakan Glide untuk load gambar dari Link URL
            Glide.with(itemView.context)
                .load(surat.gambarUrl)
                .placeholder(android.R.drawable.ic_menu_gallery) // Muncul saat gambar sedang didownload
                .error(android.R.drawable.stat_notify_error)    // Muncul jika link rusak / gambar tidak ada
                .into(imgItem)

            itemView.setOnClickListener { listener.onItemClick(surat) }
        }
    }
}