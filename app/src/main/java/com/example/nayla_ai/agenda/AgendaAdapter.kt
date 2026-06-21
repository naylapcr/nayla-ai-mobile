package com.example.nayla_ai.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R

class AgendaAdapter(private val context: AgendaListActivity, private val list: List<AgendaModel>) :
    RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvAgendaTitle)
        val edt: EditText = view.findViewById(R.id.edtMenitItem)
        val btn: Button = view.findViewById(R.id.btnSetReminderItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_agenda, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val agenda = list[position]
        holder.title.text = agenda.title
        holder.btn.setOnClickListener {
            val menit = holder.edt.text.toString().toIntOrNull() ?: 0
            if (menit > 0) {
                context.setReminder(menit, agenda.title)
                Toast.makeText(context, "Reminder ${agenda.title} diset!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun getItemCount() = list.size
}