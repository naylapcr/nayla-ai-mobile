package com.example.nayla_ai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nayla_ai.Home.HomeFragment
import com.example.nayla_ai.About.AboutFragment
import com.example.nayla_ai.Message.MessageFragment
import com.example.nayla_ai.Profile.ProfileFragment
import com.example.nayla_ai.Settings.SettingsFragment
import com.example.nayla_ai.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 2. Setup Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Nayla Apps"

        // 3. Set fragment default saat aplikasi pertama dibuka
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // 4. Logika Klik Bottom Navigation
        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    supportActionBar?.title = "Dashboard"
                    true
                }
                R.id.nav_message -> {
                    replaceFragment(MessageFragment())
                    supportActionBar?.title = "Messages"
                    true
                }
                R.id.nav_about -> {
                    replaceFragment(AboutFragment())
                    supportActionBar?.title = "About Us"
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    supportActionBar?.title = "My Profile"
                    true
                }
                R.id.nav_settings -> {
                    replaceFragment(SettingsFragment())
                    true
                }
                else -> false
            }
        }
    }

    // Fungsi pembantu untuk mengganti fragment agar kode lebih rapi
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}