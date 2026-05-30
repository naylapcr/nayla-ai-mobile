package com.example.nayla_ai.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R
import com.google.android.material.chip.ChipGroup

class MessageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_message yang sudah ada ChipGroup-nya
        return inflater.inflate(R.layout.fragment_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMessage: RecyclerView = view.findViewById(R.id.rvMessage)

        val chipGroup: ChipGroup = view.findViewById(R.id.chipGroupMessage)

        // 3. Data Dummy (Sesuai tema Nayla Apps)
        val listPesan = listOf(
            MessageModel(1, "Admin E-Commerce", "Pesanan sepatu kamu sedang dikirim!", "08:30", R.drawable.man),
            MessageModel(2, "Sistem Keamanan", "Ada login baru di perangkat lain.", "Yesterday", R.drawable.privacy),
            MessageModel(3, "Nayla", "Jangan lupa kumpul tugas prak-mobile besok.", "Monday", R.drawable.profil),
            MessageModel(4, "Support Team", "Tiket bantuan #1029 telah ditutup.", "12/05", R.drawable.woman),
            MessageModel(5, "Promo Hari Ini", "Diskon 50% untuk produk kecantikan!", "11/05", R.drawable.ads)
        )

        // 4. Konfigurasi RecyclerView
        rvMessage.layoutManager = LinearLayoutManager(context)
        val adapter = MessageAdapter(listPesan)
        rvMessage.adapter = adapter

        // 5. Logika Filter menggunakan ChipGroup (Tugas Pertemuan 9)
        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val chipId = checkedIds.firstOrNull()
            when (chipId) {
                R.id.chipAll -> {
                    Toast.makeText(context, "Menampilkan Semua Pesan", Toast.LENGTH_SHORT).show()
                    // Disini nantinya kamu bisa memfilter listPesan
                }
                R.id.chipUnread -> {
                    Toast.makeText(context, "Menampilkan Pesan Belum Dibaca", Toast.LENGTH_SHORT).show()
                }
                R.id.chipRead -> {
                    Toast.makeText(context, "Menampilkan Pesan Sudah Dibaca", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}