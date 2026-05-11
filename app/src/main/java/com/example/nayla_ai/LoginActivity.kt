package com.example.nayla_ai

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToRegister.setOnClickListener {
            Toast.makeText(this, "Tombol Terdeteksi!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val inputUser = binding.etUsername.text.toString()
            val inputPass = binding.etPassword.text.toString()

            // 1. Ambil data dari SharedPreferences (data registrasi sebelumnya)
            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedUser = sharedPref.getString("username", "")
            val savedPass = sharedPref.getString("password", "")

            // 2. Cek Kondisi Login (Sesuai Soal b3)
            if ((inputUser == inputPass && inputUser.isNotEmpty()) ||
                (inputUser == savedUser && inputPass == savedPass && inputUser.isNotEmpty())) {

                // Jika Berhasil: Arahkan ke Home
                val intent =
                    Intent(this, MainActivity::class.java) // Sesuaikan nama Home Activity kamu
                startActivity(intent)
                finish()

            } else {
                // Jika Gagal: Tampilkan MaterialAlertDialog
                showErrorDialog()
            }
        }

        // Navigasi ke halaman Register jika belum punya akun
//        binding.btnToRegister.setOnClickListener {
//            Toast.makeText(this, "Tombol Terdeteksi!", Toast.LENGTH_SHORT).show()
//
//            val intent = Intent(this, RegisterActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun showErrorDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Login Gagal")
            .setMessage("Username atau Password salah. Silakan coba lagi atau registrasi terlebih dahulu.")
            .setPositiveButton("OKE") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}