package com.example.nayla_ai

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nayla_ai.databinding.ActivityLoginBinding
import com.example.nayla_ai.pertemuan_4.MenuUtamaActivity
import com.google.android.material.snackbar.Snackbar
import kotlin.jvm.java

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Padding (Gunakan binding.root atau ID layout utama kamu)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi SharedPreferences
        val sharedPref = getSharedPreferences("UserSession", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()


            if (username.isNotEmpty() && username == password) {

                val editor = sharedPref.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.putString("username", username)
                editor.apply()

                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Snackbar.make(binding.root, "Username atau Password salah!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}