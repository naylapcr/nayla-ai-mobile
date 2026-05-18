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

class TabBFragment : Fragment(), BerkasAdapter.OnItemClickListener {

    private lateinit var rvRequirements: RecyclerView
    private val listBerkas = ArrayList<BerkasSyarat>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_tab_b
        val view = inflater.inflate(R.layout.fragment_tab_b, container, false)

        // Inisialisasi RecyclerView
        rvRequirements = view.findViewById(R.id.rvRequirements)
        rvRequirements.setHasFixedSize(true)

        // Mengisi data berkas persyaratan dari sistem layanan surat
        addDataBerkas()

        // Set LayoutManager & Adapter
        rvRequirements.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
        val adapter = BerkasAdapter(listBerkas, this)
        rvRequirements.adapter = adapter

        return view
    }

    private fun addDataBerkas() {
        listBerkas.clear()
        // Contoh link gambar berkas/dokumen dari internet
        listBerkas.add(BerkasSyarat(1, "Kartu Tanda Penduduk (KTP)", "Wajib (Asli & Fotokopi) untuk verifikasi identitas utama.", "https://disdukcapil.bulelengkab.go.id/uploads/konten/99_sudah-ktp-el-tidak-perlu-legalisir.jpg"))
        listBerkas.add(BerkasSyarat(2, "Kartu Keluarga (KK)", "Wajib (Fotokopi) untuk pengecekan data hubungan keluarga.", "https://dokar.kendalkab.go.id/upload/berita/KK_new.jpg"))
        listBerkas.add(BerkasSyarat(3, "Surat Pengantar RT/RW", "Wajib bawa bukti fisik yang sudah ditandatangani ketua RT/RW.", "https://imgv2-2-f.scribdassets.com/img/document/500224046/original/ac073d65ee/1?v=1"))
        listBerkas.add(BerkasSyarat(4, "Akta Kelahiran", "Diperlukan untuk pembuatan surat anak-anak atau pengurusan beasiswa sekolah.", "https://sidomulyo-pule.trenggalekkab.go.id/assets/files/artikel/sedang_1536721460akta-lahir-baru.jpg"))
        listBerkas.add(BerkasSyarat(5, "Pas Foto 3x4 / 4x6", "Foto terbaru background merah atau biru sesuai instruksi layanan.", "https://www.calistaphoto.com/wp-content/uploads/2023/09/pas-foto-make-up-jogja.webp"))
        listBerkas.add(BerkasSyarat(6, "Surat Nikah / Akta Cerai", "Diperlukan jika mengurus perubahan status pada KK atau domisili baru.", "https://disdukcapil.bulelengkab.go.id/uploads/konten/25_makna-dan-perbedaan-status-kawin-tercatat-dan-kawin-belum-tercatat-pada-kartu-keluarga.jpg"))
        listBerkas.add(BerkasSyarat(7, "Surat Pernyataan Bermaterai", "Dokumen keabsahan data tambahan (biasanya bermaterai Rp 10.000).", "https://cdn-web-2.ruangguru.com/landing-pages/assets/05810168-efbb-41c2-a1f8-301521969e7f.jpg"))
        listBerkas.add(BerkasSyarat(8, "Ijazah Terakhir", "Khusus pelengkap surat pengantar kerja atau keterangan tidak mampu sekolah.", "https://www.quipper.com/id/blog/wp-content/uploads/2021/09/Ijazah-SMK.webp"))
        listBerkas.add(BerkasSyarat(9, "Bukti Pembayaran PBB", "Fotokopi bukti lunas Pajak Bumi dan Bangunan tahun terakhir.", "https://www.pajak.com/storage/2023/02/pbb-758x569.jpg"))
        listBerkas.add(BerkasSyarat(10, "SK Kerja / Slip Gaji", "Kondisional untuk pengajuan jaminan kesehatan gratis atau SKTM.", "https://www.talenta.co/wp-content/uploads/2021/03/surat-keterangan-kerja-3.jpg"))
    }

    // Mengikuti standard modul penanganan klik
    override fun onItemClick(berkas: BerkasSyarat) {
        Toast.makeText(context, "Detail: ${berkas.namaBerkas}", Toast.LENGTH_SHORT).show()
    }
}