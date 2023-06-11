package com.example.ayopintar.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentLoginBinding
import com.example.ayopintar.ui.dashboard.MainActivity


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_loginFragment_to_splashFragment2)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_splashFragment2)
        }
        binding.linkDaftar.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnMasuk.setOnClickListener {
            val userName = binding.edtUsername.editText?.text.toString().trim()
            val password = binding.edtPassword.editText?.text.toString().trim()
            when {
                userName.isEmpty() -> {
                    binding.edtUsername.error = "Username tidak boleh kosong"
                }
                password.isEmpty() -> {
                    binding.edtPassword.error = "Password tidak boleh kosong"
                }
                else -> {
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                    requireActivity().finish()
                }
            }



        }
    }




}