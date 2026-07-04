package com.example.nayla_ai

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cek status login
        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            // JIKA SUDAH LOGIN: Langsung ke MainActivity (Splash tidak muncul lama)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            // JIKA BELUM LOGIN: Munculkan Splash Screen baru ke Onboarding
            setContentView(R.layout.activity_splash_screen)
            
            lifecycleScope.launch {
                delay(2000) // Tampilkan splash 2 detik
                startActivity(Intent(this@SplashScreenActivity, OnboardingActivity::class.java))
                finish()
            }
        }
    }
}