package com.example.nayla_ai.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.nayla_ai.data.AppDatabase
import com.example.nayla_ai.R
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MessageFragment : Fragment() {

    private lateinit var database: AppDatabase
    private lateinit var rvMessage: RecyclerView
    private lateinit var adapter: MessageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi Database
        database = AppDatabase.getDatabase(requireContext())

        rvMessage = view.findViewById(R.id.rvMessage)
        rvMessage.layoutManager = LinearLayoutManager(context)

        val chipGroup: ChipGroup = view.findViewById(R.id.chipGroupMessage)

        // 2. Load data dari database menggunakan Coroutine
        loadData()

        // 3. Logika Filter (Bisa disesuaikan dengan query database nantinya)
        chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
            val chipId = checkedIds.firstOrNull()
            when (chipId) {
                R.id.chipAll -> Toast.makeText(context, "Semua Pesan", Toast.LENGTH_SHORT).show()
                R.id.chipUnread -> Toast.makeText(context, "Pesan Belum Dibaca", Toast.LENGTH_SHORT).show()
                R.id.chipRead -> Toast.makeText(context, "Pesan Sudah Dibaca", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadData() {
        lifecycleScope.launch(Dispatchers.IO) {
            // 1. Ambil data dari database
            var listPesan = database.messageDao().getAllMessages()

            // 2. Jika data kosong (karena reset/install baru), isi dengan data awal
            if (listPesan.isEmpty()) {
                val initialMessages = listOf(
                    MessageModel(sender = "Admin Desa", content = "Selamat datang di aplikasi Nayla AI! Gunakan aplikasi ini untuk layanan administrasi."),
                    MessageModel(sender = "Sistem", content = "Jangan lupa untuk melengkapi data profil Anda di menu Profile."),
                    MessageModel(sender = "Layanan Surat", content = "Informasi: Pengajuan Surat Keterangan Domisili Anda telah disetujui."),
                    MessageModel(sender = "Bina Desa", content = "Ada agenda musyawarah baru besok pagi. Silakan cek menu Agenda.")
                )
                initialMessages.forEach { database.messageDao().insert(it) }
                // Ambil ulang setelah diisi
                listPesan = database.messageDao().getAllMessages()
            }

            // 3. Update UI di Main Thread
            withContext(Dispatchers.Main) {
                adapter = MessageAdapter(listPesan) { message ->
                    deleteMessage(message)
                }
                rvMessage.adapter = adapter
            }
        }
    }

    private fun deleteMessage(message: MessageModel) {
        lifecycleScope.launch(Dispatchers.IO) {
            database.messageDao().delete(message)
            val updatedList = database.messageDao().getAllMessages()
            withContext(Dispatchers.Main) {
                adapter.updateData(updatedList)
                Toast.makeText(context, "Pesan dihapus", Toast.LENGTH_SHORT).show()
            }
        }
    }
}