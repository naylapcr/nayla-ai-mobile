package com.example.nayla_ai.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nayla_ai.AuthActivity
import com.example.nayla_ai.Home.pertemuan_10.* // Pastikan semua file di sini ter-import
import com.example.nayla_ai.Home.pertemuan_4.*
import com.example.nayla_ai.Home.pertemuan_5.WebViewActivity
import com.example.nayla_ai.Home.pertemuan_9.NinthActivity
import com.example.nayla_ai.databinding.FragmentHomeBinding
import com.example.nayla_ai.pertemuan_4.KalkulatorActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val apiService = NewsApiService.instance

    companion object {
        var cachedNews: List<BeritaDesaResponse>? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol-tombol navigasi
        binding.btnP2.setOnClickListener { startActivity(Intent(requireContext(), KalkulatorActivity::class.java)) }
        binding.btnG1.setOnClickListener { startActivity(Intent(requireContext(), GallerySatuActivity::class.java)) }
        binding.btnG2.setOnClickListener { startActivity(Intent(requireContext(), GalleryDuaActivity::class.java)) }
        binding.btnWebView.setOnClickListener { startActivity(Intent(requireContext(), WebViewActivity::class.java)) }
        binding.btnP3.setOnClickListener { startActivity(Intent(requireContext(), AuthActivity::class.java)) }
        binding.btnP9.setOnClickListener { startActivity(Intent(requireContext(), NinthActivity::class.java)) }
        binding.btnP10.setOnClickListener { startActivity(Intent(requireContext(), TenthActivity::class.java)) }

        getLiveNewsData()
    }

    private fun getLiveNewsData() {

        if (cachedNews != null) {
            showNews(cachedNews!!)
        } else {
            binding.progressBar.visibility = View.VISIBLE
        }

        apiService.getNews().enqueue(object : Callback<List<BeritaDesaResponse>> {
            override fun onResponse(call: Call<List<BeritaDesaResponse>>, response: Response<List<BeritaDesaResponse>>) {
                binding.progressBar.visibility = View.GONE
                if (response.isSuccessful && response.body() != null) {
                    cachedNews = response.body()
                    showNews(cachedNews!!)
                }
            }

            override fun onFailure(call: Call<List<BeritaDesaResponse>>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(), "Gagal memuat berita", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun showNews(data: List<BeritaDesaResponse>) {
        val adapter = NewsAdapter(data)
        binding.rvNewsList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNewsList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}