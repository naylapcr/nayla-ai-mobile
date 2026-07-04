package com.example.nayla_ai

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSelanjutnya.setOnClickListener {
            saveData()
        }
    }
    private fun saveData() {
        val nama = binding.etNama.text.toString()
        val email = binding.etEmail.text.toString()
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPass = binding.etConfirmPassword.text.toString()
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month + 1
        val year = binding.datePicker.year
        val tanggalLahir = "$day/$month/$year"
        val selectedGenderId = binding.rgGender.checkedRadioButtonId

        if (nama.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Semua data wajib diisi!", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPass) {
            binding.etConfirmPassword.error = "Password tidak cocok"
            return
        }

        if (selectedGenderId == -1) {
            Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
            return
        }

        val gender = if (selectedGenderId == binding.rbLaki.id) "Laki-laki" else "Perempuan"

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", nama)
        editor.putString("email", email)
        editor.putString("dob", tanggalLahir)
        editor.putString("gender", gender)
        editor.putString("username", username)
        editor.putString("password", password)
        editor.putBoolean("isRegistered", true) // Penanda user sudah daftar
        editor.apply()

        Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}