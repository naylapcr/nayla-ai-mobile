package com.example.nayla_ai.Home.pertemuan_10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nayla_ai.R

class BerkasAdapter(
    private val listBerkas: List<BerkasSyarat>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<BerkasAdapter.BerkasViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(berkas: BerkasSyarat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BerkasViewHolder {
        // Menggunakan layout item_surat yang sama agar hemat file XML
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_surat, parent, false)
        return BerkasViewHolder(view)
    }

    override fun onBindViewHolder(holder: BerkasViewHolder, position: Int) {
        val berkas = listBerkas[position]
        holder.bind(berkas, listener)
    }

    override fun getItemCount(): Int = listBerkas.size

    class BerkasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNamaBerkas: TextView = itemView.findViewById(R.id.tvNamaSurat)
        private val tvKeterangan: TextView = itemView.findViewById(R.id.tvDeskripsiSurat)
        private val imgItem: ImageView = itemView.findViewById(R.id.imgItem)

        fun bind(berkas: BerkasSyarat, listener: OnItemClickListener) {
            tvNamaBerkas.text = berkas.namaBerkas
            tvKeterangan.text = berkas.keterangan

            Glide.with(itemView.context)
                .load(berkas.gambarUrl) // Pastikan di model data namanya 'gambarUrl' berjenis String
                .placeholder(android.R.drawable.ic_menu_gallery) // Gambar sementara pas loading
                .error(android.R.drawable.stat_notify_error)    // Gambar kalau link rusak
                .into(imgItem)

            itemView.setOnClickListener {
                listener.onItemClick(berkas)
            }
        }
    }
}