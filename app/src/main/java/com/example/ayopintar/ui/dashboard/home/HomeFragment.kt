package com.example.ayopintar.ui.dashboard.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ayopintar.api.response.DataItem
import com.example.ayopintar.databinding.FragmentHomeBinding
import com.example.ayopintar.datastore.token.TokenPreference
import com.example.ayopintar.datastore.token.TokenViewModel
import com.example.ayopintar.datastore.token.TokenViewModelFactory
import com.example.ayopintar.ui.kuis.KuisActivity
import com.example.ayopintar.ui.kuis.KuisActivity.Companion.extraIdMapel
import com.example.ayopintar.ui.kuis.KuisActivity.Companion.extraMapel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var tokenViewModel: TokenViewModel

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
        val pref = TokenPreference.getInstance(requireContext().dataStore)
        tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        tokenViewModel.getToken().observe(viewLifecycleOwner) {
            viewModel.getListMapel(it)
            viewModel.loginResult.observe(viewLifecycleOwner) { list->
                setAdapterSemuaKuis(list)
                setAdapterPoplerKuis(list)
            }}


    }

    private fun setAdapterSemuaKuis(list: List<DataItem?>?) {
                val semuaKuisAdapter = SemuaKuisAdapter(list)
                binding.rvSemuaKuis.layoutManager = LinearLayoutManager(requireContext())
                binding.rvSemuaKuis.adapter = semuaKuisAdapter
                semuaKuisAdapter.setOnItemClickCallback(object : SemuaKuisAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: DataItem?) {
                        intentStartKuis(data)
                    }
                })

    }

    private fun setAdapterPoplerKuis(list: List<DataItem?>?) {
                val semuaKuisAdapter = PopulerKuisAdapter(list)
                binding.rvKuisPopuler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.rvKuisPopuler.adapter = semuaKuisAdapter
                semuaKuisAdapter.setOnItemClickCallback(object : PopulerKuisAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: DataItem?) {
                        intentStartKuis(data)
                    }
                })

    }
    private fun intentStartKuis(data: DataItem?){
        val intent = Intent(requireActivity(), KuisActivity::class.java)
            .putExtra(extraMapel, data?.mataPelajaran)
            .putExtra(extraIdMapel, data?.kodeMatapelajaran)
        startActivity(intent)
    }

    /*private fun getListMapel(): ArrayList<PelajaranDummyResponse> {
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
        val listHero = ArrayList<PelajaranDummyResponse>()

        for (i in dataMapel.indices) {
            val hero = PelajaranDummyResponse(dataMapel[i], dataPendidikan[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}