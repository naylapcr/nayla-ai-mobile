package com.example.nayla_ai.Home.pertemuan_13

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.R
import com.example.nayla_ai.databinding.ActivityMultimediaBinding
import com.google.android.material.tabs.TabLayoutMediator

class MultimediaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMultimediaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMultimediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.apply {
            title = getString(R.string.title_multimedia)
            setDisplayHomeAsUpEnabled(true)
        }
        binding.includeToolbar.toolbar.setNavigationOnClickListener { finish() }

        // Setup ViewPager2 and TabLayout
        val adapter = MultimediaPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Kamera"
                1 -> "Generate QR"
                2 -> "Scan QR"
                else -> null
            }
            tab.icon = when (position) {
                0 -> androidx.core.content.ContextCompat.getDrawable(this, R.drawable.handphone)
                1 -> androidx.core.content.ContextCompat.getDrawable(this, R.drawable.ic_menu_seacrh) // Placeholder, sebaiknya ganti icon QR
                2 -> androidx.core.content.ContextCompat.getDrawable(this, R.drawable.ic_menu_seacrh)
                else -> null
            }
        }.attach()
    }
}