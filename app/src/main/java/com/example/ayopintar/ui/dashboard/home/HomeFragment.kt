package com.example.ayopintar.ui.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayopintar.api.response.PelajaranResponse
import com.example.ayopintar.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapterSemuaKuis()
    }

    private fun setAdapterSemuaKuis() {
        binding.rvSemuaKuis.adapter = SemuaKuisAdapter(getListMapel())
        binding.rvSemuaKuis.layoutManager = LinearLayoutManager(requireContext())

    }
    private fun getListMapel(): ArrayList<PelajaranResponse> {
        val dataMapel = arrayOf("Bahasa Indonesia", "Penjas", "IPA", "IPS", "PKN")
        val dataPendidikan = arrayOf("Sekolah Menengah Akhir", "Sekolah Menengah Kejuruan", "Sekolah Menengah Akhir", "Sekolah Menengah Akhir", "Sekolah Menengah Kejuuran")
        val dataPhoto = arrayOf("https://siedoo.com/wp-content/uploads/2020/02/bahasa_indonesia2-1280x720-1-1210x642.jpg","https://source.unsplash.com/random/900×700/?city", "https://source.unsplash.com/random/900×700/?fruit", "https://source.unsplash.com/random/900×700/?sport", "https://source.unsplash.com/random/900×700/?vegetable")
        val listHero = ArrayList<PelajaranResponse>()

        for (i in dataMapel.indices) {
            val hero = PelajaranResponse(dataMapel[i], dataPendidikan[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}