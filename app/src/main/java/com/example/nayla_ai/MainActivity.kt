package com.example.nayla_ai

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.AuthActivity
import com.example.nayla_ai.pertemuan_4.MenuUtamaActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Tidak perlu setContentView(R.layout.activity_main) karena activity ini hanya melempar halaman

        // 1. Ambil data dari SharedPreferences
        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)

        // 2. Cek status login (apakah isLoggedIn bernilai true?)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        // 3. Jalankan logika pengecekan sesuai ketentuan modul
        if (isLoggedIn) {
            // Jika sudah login (true), langsung ke Dashboard/Menu Utama
            val intent = Intent(this, MenuUtamaActivity::class.java)
            startActivity(intent)
        } else {
            // Jika belum login (false), arahkan ke halaman Login (AuthActivity)
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        // 4. Tutup MainActivity agar user tidak bisa kembali ke halaman kosong ini
        finish()
    }
}