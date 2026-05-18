package com.example.nayla_ai.Home.pertemuan_10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nayla_ai.R

class TabAFragment : Fragment(), SuratAdapter.OnItemClickListener {

    private lateinit var rvProducts: RecyclerView
    private val listSurat = ArrayList<JenisSurat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_tab_a
        val view = inflater.inflate(R.layout.fragment_tab_a, container, false)

        // Inisialisasi RecyclerView sesuai id di XML kamu
        rvProducts = view.findViewById(R.id.rvProducts)
        rvProducts.setHasFixedSize(true)

        // Memanggil data
        addDataSurat()

        // Set LayoutManager & Adapter
        rvProducts.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
        val adapter = SuratAdapter(listSurat, this)
        rvProducts.adapter = adapter

        return view
    }

    private fun addDataSurat() {
        listSurat.clear()
        // Masukkan string link URL gambar pada parameter terakhir
        listSurat.add(JenisSurat(1, "Surat Keterangan Domisili", "Surat keterangan resmi mengenai tempat tinggal/domisili warga.", "https://serayabarat.desa.id/wp-content/uploads/2022/11/surat-keterangan-domisili.jpeg"))
        listSurat.add(JenisSurat(2, "Surat Keterangan Usaha (SKU)", "Surat pernyataan resmi untuk legalitas kepemilikan suatu usaha.", "https://www.online-pajak.com/wp-content/uploads/2023/02/surat-keterangan-usaha-1-638.png"))
        listSurat.add(JenisSurat(3, "Surat Pengantar SKCK", "Surat pengantar dari desa/kelurahan untuk pembuatan SKCK.", "https://s.kaskus.id/images/2018/10/31/10113041_20181031024423.jpg"))
        listSurat.add(JenisSurat(4, "Surat Keterangan Tidak Mampu (SKTM)", "Surat untuk meringankan biaya pengobatan, sekolah, atau bantuan.", "https://www.duniakampus.id/wp-content/uploads/2024/04/contoh-sktm.webp"))
        listSurat.add(JenisSurat(5, "Surat Keterangan Kematian", "Surat laporan resmi atas meninggalnya seorang warga untuk keperluan administrasi.", "https://imgv2-2-f.scribdassets.com/img/document/444696444/original/0a9e8ea6b5/1?v=1"))
        listSurat.add(JenisSurat(6, "Surat Keterangan Kelahiran", "Surat pengantar untuk pengurusan akta kelahiran anak baru.", "https://cdn.slidesharecdn.com/ss_thumbnails/blangkosuratketerangankelahiran-141125215258-conversion-gate02-thumbnail.jpg?width=640&height=640&fit=bounds"))
        listSurat.add(JenisSurat(7, "Surat Pengantar Nikah (NA)", "Surat rekomendasi kelurahan bagi warga yang akan melangsungkan pernikahan.", "https://acaranya.id/wp-content/uploads/2024/07/IMG_20240618_125048.jpg"))
        listSurat.add(JenisSurat(8, "Surat Keterangan Pindah Datang", "Surat pengantar untuk warga yang ingin pindah domisili antar daerah atau provinsi.", "https://paperless.id/media/document-definitions/dukcapil-bandung/f-108.jpg"))
        listSurat.add(JenisSurat(9, "Surat Keterangan Bersih Diri", "Surat pernyataan bahwa warga kelurahan tidak terlibat dalam catatan kriminal.", "https://imgv2-1-f.scribdassets.com/img/document/787018215/original/efc9352492/1?v=1"))
        listSurat.add(JenisSurat(10, "Surat Izin Keramaian", "Surat pengantar izin mengadakan acara besar seperti hajatan atau konser.", "https://imgv2-2-f.scribdassets.com/img/document/448183810/original/c6cd406f57/1?v=1"))
    }

    // Handle klik item sesuai dengan interface di adapter
    override fun onItemClick(surat: JenisSurat) {
        Toast.makeText(context, "Memilih: ${surat.namaSurat}", Toast.LENGTH_SHORT).show()
    }
}