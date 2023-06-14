package com.example.ayopintar.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentNextRegisterBinding
import com.example.ayopintar.utils.InputValidate
import com.example.ayopintar.utils.PasswordChecker
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

class NextRegisterFragment : Fragment() {
    private var _binding: FragmentNextRegisterBinding? = null
    private val binding get() = _binding!!
    private val args: NextRegisterFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNextRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewModel = ViewModelProvider(requireActivity())[RegisterViewModel::class.java]

        val dataNama = args.namaLengkap
        val dataEmail = args.email
        val dataSekolah = args.asalSekolah

        binding.btnBack.setOnClickListener {
            it.findNavController().navigateUp()
        }

        Snackbar.make(
            binding.root,
            "Nama: $dataNama, noHp = $dataEmail, sekolah: $dataSekolah",
            Snackbar.LENGTH_LONG
        ).show()

        val textInputLayouts = listOf(
            Pair(binding.edtUsername, "Username"),
            Pair(binding.edtPassword, "Password"),
            Pair(binding.edtPasswordKonfirm, "Konfirmasi Password")
        )

        textInputLayouts.forEach { (textInputLayout, fieldName) ->
            textInputLayout.errorIconDrawable = null
            textInputLayout.editText?.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    InputValidate.checkEmpty(textInputLayout, fieldName)
                }
            }
            textInputLayout.editText?.addTextChangedListener {
                InputValidate.checkEmpty(textInputLayout, fieldName)
            }
        }

        binding.btnDaftar.setOnClickListener {
            val username = binding.edtUsername.editText?.text.toString()
            val pass1 = binding.edtPassword.editText?.text.toString()
            val pass2 = binding.edtPasswordKonfirm.editText?.text.toString()

            if (InputValidate.checkTextViewsEmpty(textInputLayouts) && PasswordChecker.checkSimilaritiesPassword(pass1, pass2)) {
                viewModel.postRegister(username, pass1, pass2, dataNama, dataSekolah, dataEmail)

                viewModel.registerMsg.observe(requireActivity()) {
                    if (it == "Success") {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                        view.findNavController().navigate(R.id.action_nextRegisterFragment_to_loginFragment)
                    } else {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        /*binding.edtUsername.editText?.addTextChangedListener {
            val username = binding.edtUsername
            val value = username.editText?.text.toString()
            setError(username, value.isEmpty(), "Username tidak boleh kosong")
        }*/


        binding.edtPasswordKonfirm.editText?.addTextChangedListener {
            val password1 = binding.edtPassword.editText?.text.toString()
            val password2 = binding.edtPasswordKonfirm.editText?.text.toString()
            val message = "Konfirmasi password tidak sesuai"
            setError(
                binding.edtPasswordKonfirm,
                !PasswordChecker.checkSimilaritiesPassword(password1, password2),
                message
            )

        }

        binding.edtPassword.editText?.addTextChangedListener {
            val message = getString(R.string.tooltips_password)
            setError(binding.edtPassword, !PasswordChecker.checkPasswordStrength(it.toString()), message)
        }
    }

    private fun setError(view: TextInputLayout, error: Boolean, message: String) {
        if (error) {
            view.errorIconDrawable = null
            view.error = message
            binding.btnDaftar.isEnabled = false

        } else {
            view.error = null
            binding.btnDaftar.isEnabled = true
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}