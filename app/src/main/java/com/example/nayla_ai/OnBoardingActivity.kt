package com.example.nayla_ai

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nayla_ai.LoginActivity // Sesuaikan dengan lokasi LoginActivity kamu
import com.example.nayla_ai.R

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        // 1. Inisialisasi ViewPager2
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        // 2. Set Adapter ke ViewPager2
        viewPager.adapter = OnboardingAdapter {
            // Logika saat tombol "Ayo Mulai" di slide terakhir diklik
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Tutup activity agar tidak bisa kembali ke onboarding
        }
    }
}