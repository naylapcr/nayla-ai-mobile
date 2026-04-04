package com.example.nayla_ai.pertemuan_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nayla_ai.databinding.ActivityMainBinding
import com.example.nayla_ai.databinding.ActivityMainBinding.*

class MainActivity3 : AppCompatActivity() {

    // Inisialisasi ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup ViewBinding
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        // Event Klik Tombol Login
        binding.btnLogin.setOnClickListener {
            // Berpindah ke WelcomeActivity di package pertemuan_3
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}