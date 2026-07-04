package com.example.nayla_ai

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nayla_ai.databinding.ActivityValidasiBinding

class ValidasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValidasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValidasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.apply {
            title = getString(R.string.title_validasi)
            setDisplayHomeAsUpEnabled(true)
        }
        binding.includeToolbar.toolbar.setNavigationOnClickListener { onBackPressed() }

        // 1. Ambil data dari SharedPreferences
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val name = sharedPref.getString("name", "") ?: ""
        val email = sharedPref.getString("email", "") ?: ""
        val dob = sharedPref.getString("dob", "") ?: ""
        val gender = sharedPref.getString("gender", "") ?: ""
        val user = sharedPref.getString("username", "") ?: ""

        // 2. Tampilkan ke UI
        binding.apply {
            tvValNama.text = getString(R.string.label_nama, name)
            tvValEmail.text = getString(R.string.label_email, email)
            tvValTanggal.text = getString(R.string.label_tgl_lahir, dob)
            tvValGender.text = getString(R.string.label_gender, gender)
            tvValUser.text = getString(R.string.label_username, user)
        }

        // 3. Tombol Submit (Validasi Akhir)
        binding.btnSubmit.setOnClickListener {
            // Cek apakah ada yang kosong (sesuai soal b2)
            if (name.isEmpty() || email.isEmpty() || user.isEmpty()) {
                Toast.makeText(this, getString(R.string.msg_sp_incomplete), Toast.LENGTH_SHORT).show()
            } else {
                // Jika berhasil, tampilkan pesan Registrasi Berhasil
                Toast.makeText(this, getString(R.string.msg_regis_success, name), Toast.LENGTH_LONG).show()
                // Kamu bisa arahkan ke LoginActivity atau Dashboard di sini
            }
        }

        // 4. Tombol Kembali
        binding.btnKembali.setOnClickListener {
            // Tutup halaman ini untuk balik ke halaman Registrasi (finish())
            finish()
        }
    }
}