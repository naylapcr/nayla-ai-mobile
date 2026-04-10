package com.example.nayla_ai.pertemuan_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.pertemuan_3.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // PERTEMUAN 4: Mengambil data dari Intent
        val namaDiterima = intent.getStringExtra("NAMA_USER")

        // Tampilkan ke layar
        binding.tvWelcomeNama.text = "Halo, $namaDiterima!"}
}