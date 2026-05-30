package com.example.nayla_ai.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nayla_ai.AuthActivity
import com.example.nayla_ai.Home.pertemuan_4.GalleryDuaActivity
import com.example.nayla_ai.Home.pertemuan_4.GallerySatuActivity
import com.example.nayla_ai.Home.pertemuan_5.WebViewActivity
import com.example.nayla_ai.Home.pertemuan_9.NinthActivity
import com.example.nayla_ai.databinding.FragmentHomeBinding
import com.example.nayla_ai.pertemuan_4.KalkulatorActivity

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol 1: Ke Kalkulator
        binding.btnP2.setOnClickListener {
            val intent = Intent(requireContext(), KalkulatorActivity::class.java)
            startActivity(intent)
        }

        // Tombol 2 & 3: Ke Gallery
        binding.btnG1.setOnClickListener {
            startActivity(Intent(requireContext(), GallerySatuActivity::class.java))
        }
        binding.btnG2.setOnClickListener {
            startActivity(Intent(requireContext(), GalleryDuaActivity::class.java))
        }

        // Tombol 4: Ke WebView (Layanan Surat)
        binding.btnWebView.setOnClickListener {
            startActivity(Intent(requireContext(), WebViewActivity::class.java))
        }

        // Tombol 5: Ke AuthActivity (Login P3)
        binding.btnP3.setOnClickListener {
            startActivity(Intent(requireContext(), AuthActivity::class.java))
        }

        // === TAMBAHAN UNTUK PERTEMUAN 9 ===
        // Pastikan ID tombol di fragment_home.xml adalah btnP9 atau sesuaikan dengan ID yang kamu buat
        binding.btnP9.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}