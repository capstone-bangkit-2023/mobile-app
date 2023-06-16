package com.example.ayopintar.ui.kuis.detailkuis

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.ayopintar.databinding.FragmentDetailKuisBinding
import com.example.ayopintar.datastore.token.TokenPreference
import com.example.ayopintar.datastore.token.TokenViewModel
import com.example.ayopintar.datastore.token.TokenViewModelFactory
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

        tokenViewModel.getToken().observe(viewLifecycleOwner) {
            viewModel.getSoal(it, idMapel!!)
        }

        viewModel.getSoalResult.observe(viewLifecycleOwner) {
            binding.tvSoal.text = it.soal
        }
        viewModel.isLoding.observe(viewLifecycleOwner){
            showLoading(it)
        }

        binding.btnNext.setOnClickListener {
            viewModel.getSoalResult.observe(viewLifecycleOwner) { soal ->
                val kodeSoal = soal.kodeSoal
                val jawaban = binding.edtJawaban.editText.toString()
                val toNilaiKuisFragment = DetailKuisFragmentDirections.actionDetailKuisFragmentToNilaiKuisFragment()
                toNilaiKuisFragment.kodeSoal = kodeSoal
                toNilaiKuisFragment.jawaban = jawaban
                view.findNavController().navigate(toNilaiKuisFragment)
            }
        }
    }
    private fun showLoading(isLoading: Boolean){
        with(binding){
            progressIndicator.isVisible = isLoading
            tvSoal.isInvisible = isLoading
            btnNext.isEnabled = !isLoading
        }
    }
}