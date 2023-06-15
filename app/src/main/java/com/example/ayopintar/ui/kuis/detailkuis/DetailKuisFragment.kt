package com.example.ayopintar.ui.kuis.detailkuis

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.example.ayopintar.databinding.FragmentDetailKuisBinding
import com.example.ayopintar.token.TokenPreference
import com.example.ayopintar.token.TokenViewModel
import com.example.ayopintar.token.TokenViewModelFactory
import com.example.ayopintar.ui.kuis.KuisActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

class DetailKuisFragment : Fragment() {

    private var _binding : FragmentDetailKuisBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DetailKuisViewModel
    private lateinit var tokenViewModel: TokenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idMapel = requireActivity().intent.getStringExtra(KuisActivity.extraIdMapel)
        val pref = TokenPreference.getInstance(requireContext().dataStore)
        tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]
        viewModel = ViewModelProvider(this)[DetailKuisViewModel::class.java]

        tokenViewModel.getToken().observe(this) {
            viewModel.getSoal(it, idMapel!!)
        }

        viewModel.getSoalResult.observe(this) {
            binding.tvSoal.text = it
        }
    }
}