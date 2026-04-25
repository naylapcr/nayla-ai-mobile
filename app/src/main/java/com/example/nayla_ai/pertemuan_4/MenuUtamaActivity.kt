package com.example.nayla_ai.pertemuan_4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityMenuUtamaBinding
import com.example.nayla_ai.AuthActivity
import com.example.nayla_ai.pertemuan_5.WebViewActivity
import com.google.android.material.snackbar.Snackbar

class MenuUtamaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuUtamaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- SETUP TOOLBAR ---
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Dashboard Utama" // Judul Toolbar
            setDisplayHomeAsUpEnabled(true) // Munculkan tombol back (panah)
            setDisplayShowHomeEnabled(true)
        }

        // Tombol 1: Ke Kalkulator (P2)
        binding.btnP2.setOnClickListener {
            startActivity(Intent(this, KalkulatorActivity::class.java))
        }

        // Tombol 2 & 3: Ke Gallery
        binding.btnG1.setOnClickListener {
            startActivity(Intent(this, GallerySatuActivity::class.java))
        }
        binding.btnG2.setOnClickListener {
            startActivity(Intent(this, GalleryDuaActivity::class.java))
        }

        // Tombol 4: Ke WebView (Layanan Surat)
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        // Tombol 5: Ke AuthActivity (Login P3)
        binding.btnP3.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
        }

        // Logic Logout (Sesuai ketentuan SharedPreferences)
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Konfirmasi Logout")
                setMessage("Apakah kamu yakin ingin keluar?")
                setPositiveButton("Ya") { _, _ ->
                    // Hapus Session Login
                    val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
                    sharedPref.edit().clear().apply()

                    // Pindah ke Login dan tutup dashboard
                    val intent = Intent(this@MenuUtamaActivity, AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                setNegativeButton("Tidak") { _, _ ->
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                show()
            }
        }
    }

    // --- PENTING: Agar Tombol Back di Toolbar Berfungsi ---
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}