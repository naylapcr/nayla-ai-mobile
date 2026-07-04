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

        // Gunakan view dari binding secara langsung
        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Form Layanan"
        binding.includeToolbar.toolbar.setNavigationOnClickListener { onBackPressed() }

        binding.btnKirim.setOnClickListener {
            // Mengambil teks dari Chip yang dipilih
            val selectedChipId = binding.chipGroupKategori.checkedChipId
            val kategori = findViewById<Chip>(selectedChipId)?.text.toString()

            val nama = binding.tilNama.editText?.text.toString()

            if (nama.isNotEmpty()) {
                Toast.makeText(this, "Berhasil! Pengajuan $kategori atas nama $nama telah dikirim.", Toast.LENGTH_LONG).show()
                
                // Mengosongkan form setelah berhasil kirim
                binding.tilNama.editText?.text?.clear()
                binding.tilPesan.editText?.text?.clear()
                binding.tilNama.error = null // Menghilangkan error jika ada
                binding.chipAdmin.isChecked = true // Reset kategori ke default
                
                // Menghilangkan fokus dari input agar keyboard bisa tertutup atau tidak menutupi layar
                binding.tilNama.clearFocus()
                binding.tilPesan.clearFocus()
            } else {
                binding.tilNama.error = "Harap isi nama lengkap"
            }
        }
    }
}