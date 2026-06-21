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
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.agenda.AgendaAdapter
import com.example.nayla_ai.agenda.AgendaModel
import com.example.nayla_ai.R
import com.example.nayla_ai.ReminderReceiver

class AgendaListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_list)

        val rv = findViewById<RecyclerView>(R.id.rvAgenda)
        rv.layoutManager = LinearLayoutManager(this)

        // Data agenda lengkap sesuai dengan parameter class AgendaModel
        val listData = listOf(
            AgendaModel("Musyawarah Pembangunan", "09:00 WIB", "Balai Desa"),
            AgendaModel("Gotong Royong", "07:00 WIB", "Lapangan Desa")
        )

        rv.adapter = AgendaAdapter(this, listData)
    }

    // Fungsi ini dipanggil dari AgendaAdapter saat tombol pengingat diklik
    fun setReminder(minutes: Int, title: String) {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Intent ke ReminderReceiver dengan data judul agenda
        val intent = Intent(this, ReminderReceiver::class.java).apply {
            putExtra("agenda_title", title)
        }

        // Gunakan hashCode title agar setiap agenda memiliki alarm unik
        val pi = PendingIntent.getBroadcast(
            this,
            title.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val triggerTime = System.currentTimeMillis() + (minutes * 60 * 1000)

        // Cek izin khusus untuk Android 12+ (API 31+)
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