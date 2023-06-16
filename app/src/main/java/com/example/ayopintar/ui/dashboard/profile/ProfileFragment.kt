package com.example.ayopintar.ui.dashboard.profile

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
import com.bumptech.glide.Glide
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentProfileBinding
import com.example.ayopintar.datastore.token.TokenPreference
import com.example.ayopintar.datastore.token.TokenViewModel
import com.example.ayopintar.datastore.token.TokenViewModelFactory
import com.example.ayopintar.datastore.username.UsernamePreference
import com.example.ayopintar.datastore.username.UsernameViewModel
import com.example.ayopintar.datastore.username.UsernameViewModelFactory
import com.example.ayopintar.ui.auth.AuthActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
private val Context.dataStore1: DataStore<Preferences> by preferencesDataStore(name = "username")

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = TokenPreference.getInstance(requireContext().dataStore)
        val pref1 = UsernamePreference.getInstance(requireContext().dataStore1)
        val viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        val usernameViewModel = ViewModelProvider(this, UsernameViewModelFactory(pref1))[UsernameViewModel::class.java]
        val tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]

        tokenViewModel.getToken().observe(this) { token ->
            usernameViewModel.getUsername().observe(this) { username ->
                viewModel.getProfile(token, username)
            }
        }

        viewModel.profileResult.observe(this) {
            binding.profileUsername.text = it.username
            binding.profileName.text = it.nama
            binding.profileAsalSekolah.text = it.namaSekolah
            Glide.with(requireContext())
                .load(it.foto)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.profilePicture)
        }

        binding.profileLogoutBtn.setOnClickListener {
            tokenViewModel.saveToken("")
            usernameViewModel.saveUsername("")
            startActivity(Intent(requireActivity(), AuthActivity::class.java))
            requireActivity().finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}