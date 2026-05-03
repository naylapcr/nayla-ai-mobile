package com.example.nayla_ai

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nayla_ai.Home.HomeFragment
import com.example.nayla_ai.About.AboutFragment
import com.example.nayla_ai.Profile.ProfileFragment
import com.example.nayla_ai.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi binding dengan benar
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set Toolbar manual
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Layanan Surat Desa"

        // Pasang fragment pertama
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        binding.bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.nav_about -> {
                    replaceFragment(AboutFragment())
                    true
                }
                R.id.nav_profile -> {
                    replaceFragment(ProfileFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}