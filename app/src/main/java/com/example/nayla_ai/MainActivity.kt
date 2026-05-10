package com.example.nayla_ai

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.BaseActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Membuka SharedPreferences untuk mengecek sesi pengguna
        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)

        // Mengambil status login (isLoggedIn). Jika belum ada data, default-nya false
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        // Logika Pengalihan Halaman:
        if (isLoggedIn) {
            val intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        // Tutup MainActivity agar tidak bisa balik lagi ke sini dengan tombol back
        finish()
    }
}