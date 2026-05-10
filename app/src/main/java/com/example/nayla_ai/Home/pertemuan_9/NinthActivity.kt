package com.example.nayla_ai.Home.pertemuan_9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nayla_ai.BaseActivity
import com.example.nayla_ai.R
import com.example.nayla_ai.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            // Mengambil teks dari Chip yang dipilih
            val selectedChipId = binding.chipGroupKategori.checkedChipId
            val kategori = findViewById<Chip>(selectedChipId)?.text.toString()

            val nama = binding.tilNama.editText?.text.toString()

            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Berhasil! Pengajuan $kategori atas nama $nama telah dikirim.", Toast.LENGTH_LONG).show()
                // Kamu bisa tambahkan finish() atau pindah halaman ke Dashboard
            } else {
                binding.tilNama.error = "Harap isi nama lengkap"
            }
        }
    }
}