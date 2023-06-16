package com.example.ayopintar.ui.dashboard.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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
import com.example.ayopintar.datastore.username.UsernamePreference
import com.example.ayopintar.datastore.username.UsernameViewModel
import com.example.ayopintar.datastore.username.UsernameViewModelFactory
import com.example.ayopintar.ui.dashboard.profile.ProfileViewModel
import com.example.ayopintar.ui.kuis.KuisActivity
import com.example.ayopintar.ui.kuis.KuisActivity.Companion.extraIdMapel
import com.example.ayopintar.ui.kuis.KuisActivity.Companion.extraMapel

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
private val Context.dataStore1: DataStore<Preferences> by preferencesDataStore(name = "username")

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HomeViewModel
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var tokenViewModel: TokenViewModel
    private lateinit var usernameViewModel: UsernameViewModel

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
        val pref1 = UsernamePreference.getInstance(requireContext().dataStore1)
        usernameViewModel = ViewModelProvider(this, UsernameViewModelFactory(pref1))[UsernameViewModel::class.java]
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]

        tokenViewModel.getToken().observe(viewLifecycleOwner) { token ->
            usernameViewModel.getUsername().observe(this) { username ->
                profileViewModel.getProfile(token, username)
            }
            viewModel.getListMapel(token)
            viewModel.loginResult.observe(viewLifecycleOwner) { list->
                setAdapterSemuaKuis(list)
                setAdapterPoplerKuis(list)
            }
        }

       profileViewModel.profileResult.observe(this) {
            binding.namaLengkap.text = it.nama
            binding.sekolah.text = it.namaSekolah
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            showLoading(it)
        }
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
    private fun showLoading(isLoading: Boolean){
        binding.progressIndicator.isVisible = isLoading
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}