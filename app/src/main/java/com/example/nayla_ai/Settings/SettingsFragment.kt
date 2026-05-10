package com.example.nayla_ai.Settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nayla_ai.R
import com.example.nayla_ai.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data menu yang bagus
        val listMenu = listOf(
            SettingItem("Profil Saya", "Ubah nama, foto, dan info akun", R.drawable.profil),
            SettingItem("Notifikasi", "Atur suara dan tanda pesan masuk", R.drawable.notification),
            SettingItem("Keamanan", "Ganti kata sandi dan privasi", R.drawable.insurance),
            SettingItem("Bahasa", "Pilih bahasa aplikasi (Indonesia/English)", R.drawable.internet),
            SettingItem("Keluar", "Keluar dari akun Nayla Apps", R.drawable.logout)
        )

        // Setting RecyclerView
        binding.rvSettings.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = SettingsAdapter(listMenu)
            setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}