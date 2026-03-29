package com.example.nayla_ai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Bangun Datar (Lingkaran)
        val etJariDatar = findViewById<EditText>(R.id.etJariDatar)
        val btnHitungDatar = findViewById<Button>(R.id.btnHitungDatar)
        val tvHasilDatar = findViewById<TextView>(R.id.tvHasilDatar)

        // Inisialisasi Bangun Ruang (Tabung)
        val etJariRuang = findViewById<EditText>(R.id.etJariRuang)
        val etTinggiRuang = findViewById<EditText>(R.id.etTinggiRuang)
        val btnHitungRuang = findViewById<Button>(R.id.btnHitungRuang)
        val tvHasilRuang = findViewById<TextView>(R.id.tvHasilRuang)

        // Logika Hitung Luas Lingkaran
        btnHitungDatar.setOnClickListener {
            val rInput = etJariDatar.text.toString()

            if (rInput.isNotEmpty()) {
                val r = rInput.toDouble()
                val hasil = 3.14 * r * r // Rumus: PI * r^2

                tvHasilDatar.text = "Luas: $hasil cm²"

                // Menampilkan di Logcat (Sesuai tugas praktikum)
                Log.d("PRAKTIKUM_NAYLA", "Hitung Luas Lingkaran: r=$r, Hasil=$hasil")
            } else {
                Toast.makeText(this, "Isi jari-jari dulu ya!", Toast.LENGTH_SHORT).show()
            }
        }

        // Logika Hitung Volume Tabung
        btnHitungRuang.setOnClickListener {
            val rInput = etJariRuang.text.toString()
            val tInput = etTinggiRuang.text.toString()

            if (rInput.isNotEmpty() && tInput.isNotEmpty()) {
                val r = rInput.toDouble()
                val t = tInput.toDouble()
                val hasil = 3.14 * r * r * t // Rumus: PI * r^2 * t

                tvHasilRuang.text = "Volume: $hasil cm³"

                // Menampilkan di Logcat
                Log.d("PRAKTIKUM_NAYLA", "Hitung Volume Tabung: r=$r, t=$t, Hasil=$hasil")
            } else {
                Toast.makeText(this, "Input Tabung belum lengkap!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}