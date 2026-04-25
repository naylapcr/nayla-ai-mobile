package com.example.nayla_ai.pertemuan_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityGalleryDuaBinding



class GalleryDuaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGalleryDuaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryDuaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}