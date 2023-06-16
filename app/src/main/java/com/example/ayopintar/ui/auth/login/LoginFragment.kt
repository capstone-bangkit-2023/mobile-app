package com.example.ayopintar.ui.auth.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentLoginBinding
import com.example.ayopintar.datastore.token.TokenPreference
import com.example.ayopintar.datastore.token.TokenViewModel
import com.example.ayopintar.datastore.token.TokenViewModelFactory
import com.example.ayopintar.ui.dashboard.MainActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")

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

        val pref = TokenPreference.getInstance(requireContext().dataStore)
        val tokenViewModel = ViewModelProvider(this, TokenViewModelFactory(pref))[TokenViewModel::class.java]
        val viewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]

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
                    viewModel.postLogin(userName, password)
                }
            }

            viewModel.isLoading.observe(requireActivity()) {
                showLoading(it)
            }

            viewModel.loginResult.observe(requireActivity()) {
                tokenViewModel.saveToken(it.accessToken)
            }

            viewModel.loginMsg.observe(requireActivity()) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }

            tokenViewModel.getToken().observe(requireActivity()) {
                if (it != "") {
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                    requireActivity().finish()
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        with(binding) {
            loadingIndicator.isVisible = isLoading
            binding.btnMasuk.isEnabled = !isLoading
        }

    }
}