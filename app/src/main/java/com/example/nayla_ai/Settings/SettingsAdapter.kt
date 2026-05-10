package com.example.nayla_ai.Settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.databinding.ItemSettingBinding
import java.util.Collections.list

data class SettingItem(val title: String, val desc: String, val iconRes: Int)

class SettingsAdapter(private val list: List<SettingItem>) : RecyclerView.Adapter<SettingsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemSettingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Menggunakan View Binding untuk inflate layout
        val binding = ItemSettingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        // Memasukkan data ke dalam view melalui binding
        holder.binding.apply {
            tvMenuTitle.text = item.title
            tvMenuDesc.text = item.desc
            ivIcon.setImageResource(item.iconRes)
        }
    }

    override fun getItemCount(): Int = list.size
}
