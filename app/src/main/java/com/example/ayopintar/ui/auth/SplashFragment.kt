package com.example.ayopintar.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.appMulaiButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_splashFragment_to_registerFragment)
        }
        binding.appMulaiText4.setOnClickListener {
            it.findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }


}