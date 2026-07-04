package com.example.nayla_ai.pertemuan_4

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityKalkulatorBinding
import java.util.Locale

class KalkulatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKalkulatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKalkulatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.apply {
            title = "Kalkulator Bangun"
            setDisplayHomeAsUpEnabled(true) // Munculkan tombol panah back
            setDisplayShowHomeEnabled(true)
        }
        binding.btnHitungDatar.setOnClickListener {
            val input = binding.etJariDatar.text.toString()

            if (input.isNotEmpty()) {
                val r = input.toDouble()
                val luas = Math.PI * r * r
                binding.tvHasilDatar.text = String.format(Locale.getDefault(), "Hasil Luas: %.2f", luas)
            } else {
                Toast.makeText(this, "Masukkan jari-jari lingkaran!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnHitungRuang.setOnClickListener {
            val inputR = binding.etJariRuang.text.toString()
            val inputT = binding.etTinggiRuang.text.toString()
            if (inputR.isNotEmpty() && inputT.isNotEmpty()) {
                val r = inputR.toDouble()
                val t = inputT.toDouble()
                val volume = Math.PI * r * r * t
                binding.tvHasilRuang.text = String.format(Locale.getDefault(), "Hasil Volume: %.2f", volume)
            } else {
                Toast.makeText(this, "Lengkapi data!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}