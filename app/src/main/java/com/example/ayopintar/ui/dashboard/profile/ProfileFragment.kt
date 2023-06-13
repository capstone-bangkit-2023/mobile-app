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
import com.example.ayopintar.databinding.FragmentProfileBinding
import com.example.ayopintar.token.TokenPreference
import com.example.ayopintar.token.TokenViewModel
import com.example.ayopintar.token.TokenViewModelFactory
import com.example.ayopintar.ui.auth.AuthActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

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
        val tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]

        binding.profileLogoutBtn.setOnClickListener {
            tokenViewModel.saveToken("")
            startActivity(Intent(requireActivity(), AuthActivity::class.java))
            requireActivity().finish()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}