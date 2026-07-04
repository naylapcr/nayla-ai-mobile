package com.example.nayla_ai.agenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AgendaAdapter(private val context: AgendaListActivity, private val list: List<AgendaModel>) :
    RecyclerView.Adapter<AgendaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvAgendaTitle)
        val info: TextView = view.findViewById(R.id.tvAgendaInfo)
        val btnSetReminder: MaterialButton = view.findViewById(R.id.btnSetReminder)
        val reminderInputLayout: LinearLayout = view.findViewById(R.id.reminderInputLayout)
        val edtMenit: TextInputEditText = view.findViewById(R.id.edtMenitItem)
        val btnConfirm: MaterialButton = view.findViewById(R.id.btnConfirmReminder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_agenda, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val agenda = list[position]
        holder.title.text = agenda.title
        holder.info.text = "${agenda.time} • ${agenda.location}"

        // Toggle input pengingat
        holder.btnSetReminder.setOnClickListener {
            if (holder.reminderInputLayout.visibility == View.VISIBLE) {
                holder.reminderInputLayout.visibility = View.GONE
            } else {
                holder.reminderInputLayout.visibility = View.VISIBLE
            }
        }

        holder.btnConfirm.setOnClickListener {
            val menitText = holder.edtMenit.text.toString()
            if (menitText.isNotEmpty()) {
                val menit = menitText.toIntOrNull() ?: 0
                if (menit > 0) {
                    context.setReminder(menit, agenda.title)
                    Toast.makeText(context, "Pengingat '${agenda.title}' diset $menit menit sebelumnya", Toast.LENGTH_SHORT).show()
                    holder.reminderInputLayout.visibility = View.GONE
                    holder.edtMenit.text?.clear()
                } else {
                    Toast.makeText(context, "Masukkan menit yang valid", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Isi menit pengingat", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount() = list.size
}