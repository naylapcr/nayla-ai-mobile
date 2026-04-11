package com.example.nayla_ai.pertemuan_4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.MainActivity
import com.example.nayla_ai.pertemuan_3.LoginActivity // Import login lama kamu
import com.example.nayla_ai.pertemuan_3.databinding.ActivityMenuUtamaBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.jvm.java

class MenuUtamaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuUtamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol 1: Ke Pertemuan 2 (Ganti SecondActivity sesuai nama file kamu di P2)
        binding.btnP2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Tombol 2 & 3: Ke Halaman Gambar + Teks
        binding.btnG1.setOnClickListener {
            startActivity(Intent(this, GallerySatuActivity::class.java))
        }
        binding.btnG2.setOnClickListener {
            startActivity(Intent(this, GalleryDuaActivity::class.java))
        }

        // Tombol 4: Ke Login Pertemuan 3
        binding.btnP3.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        // Logic Logout (AlertDialog + Snackbar)
        binding.btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Logout")
            builder.setMessage("Apakah kamu yakin ingin keluar?")

            builder.setPositiveButton("Ya") { _, _ ->
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Menutup halaman dashboard
            }

            builder.setNegativeButton("Tidak") { _, _ ->
                Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
            }

            builder.show()
        }
    }
}