package com.example.ayopintar.ui.dashboard.riwayatkuis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayopintar.api.response.DataItemNilai
import com.example.ayopintar.databinding.FragmentRiwayatKuisBinding


class RiwayatKuisFragment : Fragment() {
    private var _binding: FragmentRiwayatKuisBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRiwayatKuisBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapterRiwayatKuis(getListMapel())
    }

    private fun setAdapterRiwayatKuis(list: List<DataItemNilai?>) {
        val semuaKuisAdapter = RiwayatKuisadapter(list)
        binding.rvRiwayatKuis.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRiwayatKuis.adapter = semuaKuisAdapter
    }

    private fun getListMapel(): ArrayList<DataItemNilai> {
        val dataMapel = arrayOf("Bahasa Indonesia", "Penjas", "IPA", "IPS", "PKN")
        val dataPendidikan = arrayOf(
            "Sekolah Menengah Akhir",
            "Sekolah Menengah Kejuruan",
            "Sekolah Menengah Akhir",
            "Sekolah Menengah Akhir",
            "Sekolah Menengah Kejuuran"
        )
        val dataPhoto = arrayOf(
            "https://siedoo.com/wp-content/uploads/2020/02/bahasa_indonesia2-1280x720-1-1210x642.jpg",
            "https://source.unsplash.com/random/900×700/?city",
            "https://source.unsplash.com/random/900×700/?fruit",
            "https://source.unsplash.com/random/900×700/?sport",
            "https://source.unsplash.com/random/900×700/?vegetable"
        )
        val dataNilai = arrayOf(
            90,
            70,
            90,
            100,
            10,
        )
        val listNilai = ArrayList<DataItemNilai>()

        for (i in dataMapel.indices) {
            val nilai = DataItemNilai(dataPhoto[i], dataPendidikan[i], dataMapel[i], dataNilai[i])
            listNilai.add(nilai)
        }
        return listNilai
    }
}