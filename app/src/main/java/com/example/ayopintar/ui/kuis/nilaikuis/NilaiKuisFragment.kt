package com.example.ayopintar.ui.kuis.nilaikuis

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentNilaiKuisBinding
import com.example.ayopintar.token.TokenPreference
import com.example.ayopintar.token.TokenViewModel
import com.example.ayopintar.token.TokenViewModelFactory
import com.example.ayopintar.ui.dashboard.MainActivity
import com.example.ayopintar.datastore.token.TokenPreference
import com.example.ayopintar.datastore.token.TokenViewModel
import com.example.ayopintar.datastore.token.TokenViewModelFactory
import com.example.ayopintar.ui.kuis.KuisActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

class NilaiKuisFragment : Fragment() {

    private var _binding: FragmentNilaiKuisBinding? = null
    private val binding get() = _binding!!
    private val args: NilaiKuisFragmentArgs by navArgs()

    private lateinit var tokenViewModel: TokenViewModel
    private lateinit var viewmodel: NilaiKuisViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentNilaiKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView4.text = getString(
            R.string.kuis_nilai_mapel,
            requireActivity().intent.getStringExtra(KuisActivity.extraMapel)
        )

        val pref = TokenPreference.getInstance(requireContext().dataStore)
        tokenViewModel =
            ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]
        viewmodel = ViewModelProvider(this)[NilaiKuisViewModel::class.java]
        val kodeSoal = args.kodeSoal
        val jawaban = args.jawaban


        tokenViewModel.getToken().observe(viewLifecycleOwner) { token ->
            viewmodel.postJawaban(token, kodeSoal, jawaban)
        }

        viewmodel.nilaiResult.observe(viewLifecycleOwner) {
            binding.tvNilai.text = it
        }
        viewmodel.isLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
        binding.linkBeranda.setOnClickListener{startActivity(Intent(requireContext(), MainActivity::class.java))}
    }

    private fun showLoading(isLoading: Boolean) {
        with(binding) {
            tvNilai.isInvisible = isLoading
            progressIndicator.isVisible = isLoading
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}