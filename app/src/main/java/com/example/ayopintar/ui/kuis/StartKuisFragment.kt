package com.example.ayopintar.ui.kuis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentStartKuisBinding


class StartKuisFragment : Fragment() {
    private var _binding : FragmentStartKuisBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartKuisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapel = requireActivity().intent.getStringExtra(KuisActivity.extraMapel)
        if (mapel != null)   binding.tvMapel.text = mapel

        binding.btnBack.setOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_startKuisFragment_to_detailKuisFragment)
        }
    }
}