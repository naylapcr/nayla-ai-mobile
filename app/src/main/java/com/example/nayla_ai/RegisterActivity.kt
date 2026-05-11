package com.example.nayla_ai

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        // Ambil Tanggal dari DatePicker
        val day = binding.datePicker.dayOfMonth
        val month = binding.datePicker.month + 1
        val year = binding.datePicker.year
        val tanggalLahir = "$day/$month/$year"

        // Ambil Gender
        val selectedGenderId = binding.rgGender.checkedRadioButtonId
        val gender = if (selectedGenderId == binding.rbLaki.id) "Laki-laki" else "Perempuan"

        // Validasi Sederhana
        if (nama.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Semua data wajib diisi!", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPass) {
            binding.etConfirmPassword.error = "Password tidak cocok"
            return
        }

        // SIMPAN KE SHAREDPREFERENCES
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("name", nama)
        editor.putString("email", email)
        editor.putString("dob", tanggalLahir)
        editor.putString("gender", gender)
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()

        Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()


    }
}