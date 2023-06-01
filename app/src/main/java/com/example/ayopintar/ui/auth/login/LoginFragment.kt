package com.example.ayopintar.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentLoginBinding
import com.example.ayopintar.ui.dashboard.MainActivity


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

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
            it.findNavController().navigateUp()
        }

        binding.linkDaftar.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.edtUsername.errorIconDrawable = null
        binding.edtPassword.errorIconDrawable = null

        //Check input during text or input change
        binding.edtUsername.editText?.addTextChangedListener {
            if (binding.edtUsername.editText?.text.toString().isEmpty()) {
                binding.edtUsername.error = "Username tidak boleh kosong"
            } else {
                binding.edtUsername.error = null
            }
        }

        //Check input when out of focus
        binding.edtUsername.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus && binding.edtUsername.editText?.text.toString().isEmpty()) {
                binding.edtUsername.error = "Username tidak boleh kosong"
            }
        }

        //Check input during text or input change
        binding.edtPassword.editText?.addTextChangedListener {
            if (binding.edtPassword.editText?.text.toString().isEmpty()) {
                binding.edtPassword.error = "Password tidak boleh kosong"
            } else if (binding.edtPassword.editText?.text.toString().length < 8) {
                binding.edtPassword.error = "Password kurang dari 8 karakter"
            } else {
                binding.edtPassword.error = null
            }
        }

        //Check input when out of focus
        binding.edtPassword.editText?.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus && binding.edtPassword.editText?.text.toString().isEmpty()) {
                binding.edtPassword.error = "Password tidak boleh kosong"
            } else if (!hasFocus && binding.edtPassword.editText?.text.toString().length < 8) {
                binding.edtPassword.error = "Password kurang dari 8 karakter"
            }
        }

        binding.btnMasuk.setOnClickListener {
            val userName = binding.edtUsername.editText?.text.toString().trim()
            val password = binding.edtPassword.editText?.text.toString().trim()
            when {
                userName.isEmpty() && password.isEmpty() -> {
                    binding.edtUsername.error = "Username tidak boleh kosong"
                    binding.edtPassword.error = "Password tidak boleh kosong"
                }
                userName.isEmpty() -> {
                    binding.edtUsername.error = "Username tidak boleh kosong"
                }
                password.isEmpty() -> {
                    binding.edtPassword.error = "Password tidak boleh kosong"
                }
                password.length < 8 -> {
                    binding.edtPassword.error = "Password kurang dari 8 karakter"
                }
                else -> startActivity(Intent(requireActivity(), MainActivity::class.java))
            }
        }
    }
}