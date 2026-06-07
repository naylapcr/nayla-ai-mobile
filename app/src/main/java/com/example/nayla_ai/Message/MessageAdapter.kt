package com.example.nayla_ai.Message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R

class MessageAdapter(
    private var listPesan: List<MessageModel>,
    private val onDeleteClick: (MessageModel) -> Unit // Callback untuk menghapus
) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listPesan[position]
        holder.tvName.text = data.sender
        holder.tvMessage.text = data.content

        // Logika hapus saat item ditekan lama
        holder.itemView.setOnLongClickListener {
            onDeleteClick(data)
            true
        }
    }

    override fun getItemCount(): Int = listPesan.size

    fun updateData(newList: List<MessageModel>) {
        listPesan = newList
        notifyDataSetChanged()
    }
}
