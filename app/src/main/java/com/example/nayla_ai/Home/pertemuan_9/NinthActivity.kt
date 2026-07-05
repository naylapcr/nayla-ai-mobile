package com.example.nayla_ai.Home.pertemuan_9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nayla_ai.BaseActivity
import com.example.nayla_ai.R
import com.example.nayla_ai.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupListeners()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "" // Judul sudah ada di layout custom
        }
        binding.includeToolbar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setupListeners() {
        // Hilangkan error saat user mulai mengetik
        binding.tilNama.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.tilNama.error = null
        }
        
        binding.tilPesan.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) binding.tilPesan.error = null
        }

        binding.btnKirim.setOnClickListener {
            validateAndSubmit()
        }
    }

    private fun validateAndSubmit() {
        val selectedChipId = binding.chipGroupKategori.checkedChipId
        val kategori = findViewById<Chip>(selectedChipId)?.text.toString()
        val nama = binding.tilNama.editText?.text.toString().trim()
        val pesan = binding.tilPesan.editText?.text.toString().trim()

        var isValid = true

        if (nama.isEmpty()) {
            binding.tilNama.error = "Nama lengkap harus diisi"
            isValid = false
        }

        if (pesan.isEmpty()) {
            binding.tilPesan.error = "Detail keperluan harus diisi"
            isValid = false
        }

        if (isValid) {
            showSuccessDialog(kategori, nama)
        }
    }

    private fun showSuccessDialog(kategori: String, nama: String) {
        com.google.android.material.dialog.MaterialAlertDialogBuilder(this)
            .setTitle("Pengajuan Terkirim")
            .setMessage("Terima kasih $nama, pengajuan untuk kategori $kategori telah kami terima dan akan segera diproses.")
            .setPositiveButton("OKE") { _, _ ->
                resetForm()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetForm() {
        binding.tilNama.editText?.text?.clear()
        binding.tilPesan.editText?.text?.clear()
        binding.tilNama.error = null
        binding.tilPesan.error = null
        binding.chipAdmin.isChecked = true
        binding.tilNama.clearFocus()
        binding.tilPesan.clearFocus()
    }
}