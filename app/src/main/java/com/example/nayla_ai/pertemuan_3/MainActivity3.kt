package com.example.nayla_ai.pertemuan_3 // 1. ALAMAT HARUS ADA .pertemuan_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// 2. IMPORT INI WAJIB ADA AGAR BINDINGNYA KETEMU
import com.example.nayla_ai.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 3. INISIALISASI BINDING
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. LOGIKA TOMBOL LOGIN
        binding.btnLogin.setOnClickListener {
            // Karena sudah satu folder (package), tidak perlu import WelcomeActivity lagi
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}