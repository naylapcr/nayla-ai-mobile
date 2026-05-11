package com.example.nayla_ai

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nayla_ai.databinding.ActivityValidasiBinding

class ValidasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValidasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Ambil data dari SharedPreferences
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name", "") ?: ""
        val email = sharedPref.getString("email", "") ?: ""
        val dob = sharedPref.getString("dob", "") ?: ""
        val gender = sharedPref.getString("gender", "") ?: ""
        val user = sharedPref.getString("username", "") ?: ""
        val pass = sharedPref.getString("password", "") ?: ""

        // 2. Tampilkan ke UI
        binding.apply {
            tvValNama.text = "Nama: $name"
            tvValEmail.text = "Email: $email"
            tvValTanggal.text = "Tgl Lahir: $dob"
            tvValGender.text = "Gender: $gender"
            tvValUser.text = "Username: $user"
        }

        // 3. Tombol Submit (Validasi Akhir)
        binding.btnSubmit.setOnClickListener {
            // Cek apakah ada yang kosong (sesuai soal b2)
            if (name.isEmpty() || email.isEmpty() || user.isEmpty()) {
                Toast.makeText(this, "Data di SP tidak lengkap!", Toast.LENGTH_SHORT).show()
            } else {
                // Jika berhasil, tampilkan pesan Registrasi Berhasil
                Toast.makeText(this, "Registrasi Berhasil! Selamat datang $name", Toast.LENGTH_LONG).show()
                // Kamu bisa arahkan ke LoginActivity atau Dashboard di sini
            }
        }

        // 4. Tombol Kembali
        binding.btnKembali.setOnClickListener {
            // Tutup halaman ini untuk balik ke halaman Registrasi (finish())
            finish()
        }
    }
}