package com.example.nayla_ai

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.agenda.AgendaListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi Notification Channel untuk Bina Desa
        createNotificationChannel()

        // 2. Cek apakah aplikasi dibuka dari klik notifikasi
        val target = intent.getStringExtra("nav_target")
        if (target == "kegiatan_desa_page") {
            startActivity(Intent(this, AgendaListActivity::class.java))
            finish()
            return
        }

        // 3. Membuka SharedPreferences untuk mengecek sesi pengguna
        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        // 4. Logika Pengalihan Halaman:
        if (isLoggedIn) {
            val intent = Intent(this, BaseActivity::class.java)
            // Jika ada target dari notifikasi, kirimkan target tersebut ke BaseActivity
            if (target != null) {
                intent.putExtra("nav_target", target)
            }
            startActivity(intent)
        } else {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        // Tutup MainActivity agar tidak bisa balik lagi ke sini dengan tombol back
        finish()
    }

    // Fungsi untuk membuat Notification Channel (Wajib untuk Android O ke atas)
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "BINA_DESA_CHANNEL",
                "Kegiatan Desa",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
}