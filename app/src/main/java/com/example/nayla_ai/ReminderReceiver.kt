package com.example.nayla_ai

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class ReminderReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        // 1. Ambil data nama agenda dan target navigasi
        val agendaTitle = intent.getStringExtra("agenda_title") ?: "Agenda Desa"
        val target = intent.getStringExtra("nav_target") ?: "kegiatan_desa_page"

        // 2. Siapkan intent untuk membuka MainActivity
        val resultIntent = Intent(context, MainActivity::class.java).apply {
            putExtra("nav_target", target)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        // 3. Gunakan hashCode() dari title sebagai requestCode agar notifikasi tidak tertumpuk
        val requestCode = agendaTitle.hashCode()

        val pendingIntent = android.app.PendingIntent.getActivity(
            context,
            requestCode,
            resultIntent,
            android.app.PendingIntent.FLAG_UPDATE_CURRENT or android.app.PendingIntent.FLAG_IMMUTABLE
        )

        // 4. Update judul notifikasi dengan nama agenda
        val builder = NotificationCompat.Builder(context, "BINA_DESA_CHANNEL")
            .setSmallIcon(R.drawable.logo_sidera)
            .setContentTitle("Pengingat: $agendaTitle")
            .setContentText("Jadwal Anda akan segera dimulai!")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context)

        // 5. Pengecekan izin untuk Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                notificationManager.notify(requestCode, builder.build())
            }
        } else {
            notificationManager.notify(requestCode, builder.build())
        }
    }
}