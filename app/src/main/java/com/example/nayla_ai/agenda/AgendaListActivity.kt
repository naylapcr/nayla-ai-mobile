package com.example.nayla_ai.agenda

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nayla_ai.R
import com.example.nayla_ai.ReminderReceiver
import com.example.nayla_ai.databinding.ActivityAgendaListBinding

class AgendaListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.includeToolbar.toolbar)
        supportActionBar?.apply {
            title = "Agenda Desa"
            setDisplayHomeAsUpEnabled(true)
        }
        binding.includeToolbar.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        binding.rvAgenda.layoutManager = LinearLayoutManager(this)

        val listData = listOf(
            AgendaModel("Musyawarah Pembangunan", "09:00 WIB", "Balai Desa"),
            AgendaModel("Gotong Royong Bersama", "07:00 WIB", "Lapangan Utama"),
            AgendaModel("Posyandu Balita & Lansia", "08:30 WIB", "PKK Center"),
            AgendaModel("Sosialisasi Dana Desa", "14:00 WIB", "Aula Kantor Desa"),
            AgendaModel("Rapat Karang Taruna", "19:30 WIB", "Rumah Pak RT 04")
        )

        binding.rvAgenda.adapter = AgendaAdapter(this, listData)
    }

    fun setReminder(minutes: Int, title: String) {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, ReminderReceiver::class.java).apply {
            putExtra("agenda_title", title)
        }

        val pi = PendingIntent.getBroadcast(
            this,
            title.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val triggerTime = System.currentTimeMillis() + (minutes * 60 * 1000)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (am.canScheduleExactAlarms()) {
                am.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pi)
            } else {
                Toast.makeText(this, "Mohon izinkan alarm presisi di pengaturan", Toast.LENGTH_LONG).show()
            }
        } else {
            am.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pi)
        }
    }
}