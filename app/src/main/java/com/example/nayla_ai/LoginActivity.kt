package com.example.nayla_ai

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nayla_ai.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val inputUser = binding.etUsername.text.toString()
            val inputPass = binding.etPassword.text.toString()

            val sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedUser = sharedPref.getString("username", "")
            val savedPass = sharedPref.getString("password", "")

            if ((inputUser == inputPass && inputUser.isNotEmpty()) ||
                (inputUser == savedUser && inputPass == savedPass && inputUser.isNotEmpty())) {

                val sessionPref = getSharedPreferences("UserSession", MODE_PRIVATE)
                val editor = sessionPref.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                val intent =
                    Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                showErrorDialog()
            }
        }

    }

    private fun showErrorDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Login Gagal")
            .setMessage("Username atau Password salah. Silakan coba lagi atau registrasi terlebih dahulu.")
            .setPositiveButton("OKE") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}