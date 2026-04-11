package com.example.nayla_ai

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.pertemuan_3.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    // Inisialisasi binding untuk mengakses komponen XML
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memasang layout menggunakan ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. LOGIKA BANGUN DATAR: LUAS LINGKARAN
        binding.btnHitungDatar.setOnClickListener {
            val input = binding.etJariDatar.text.toString()

            if (input.isNotEmpty()) {
                val r = input.toDouble()
                val luas = Math.PI * r * r

                // Menampilkan hasil dengan 2 angka di belakang koma
                binding.tvHasilDatar.text = String.Companion.format(Locale.getDefault(), "Hasil Luas: %.2f", luas)
            } else {
                showToast("Masukkan jari-jari lingkaran!")
            }
        }

        // 2. LOGIKA BANGUN RUANG: VOLUME TABUNG
        binding.btnHitungRuang.setOnClickListener {
            val inputR = binding.etJariRuang.text.toString()
            val inputT = binding.etTinggiRuang.text.toString()

            if (inputR.isNotEmpty() && inputT.isNotEmpty()) {
                val r = inputR.toDouble()
                val t = inputT.toDouble()
                val volume = Math.PI * r * r * t

                binding.tvHasilRuang.text = String.Companion.format(Locale.getDefault(), "Hasil Volume: %.2f", volume)
            } else {
                showToast("Lengkapi data jari-jari dan tinggi!")
            }
        }
    }

    // Fungsi tambahan agar kode lebih rapi saat memanggil Toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}