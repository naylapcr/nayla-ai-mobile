package com.example.nayla_ai.pertemuan_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.pertemuan_3.databinding.ActivityLoginBinding
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val nama = binding.etUsername.text.toString()

            if (nama.isEmpty()) {
                binding.etUsername.error = "Nama tidak boleh kosong!"
            } else {
                // PERTEMUAN 4: Intent Eksplisit + Kirim Data
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("NAMA_USER", nama) // "NAMA_USER" adalah kunci/labelnya
                startActivity(intent)
            }
        }

    }
}