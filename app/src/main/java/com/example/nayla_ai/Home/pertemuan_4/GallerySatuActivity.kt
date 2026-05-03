package com.example.nayla_ai.Home.pertemuan_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityGallerySatuBinding


class GallerySatuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGallerySatuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGallerySatuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}