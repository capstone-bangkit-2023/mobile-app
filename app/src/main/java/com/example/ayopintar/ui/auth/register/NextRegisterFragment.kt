package com.example.ayopintar.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ayopintar.R
import com.example.ayopintar.databinding.FragmentNextRegisterBinding
import com.example.ayopintar.utils.InputValidate.checkTextViewEmpty
import com.example.ayopintar.utils.PasswordChecker.checkPasswordStrength
import com.example.ayopintar.utils.PasswordChecker.checkSimilaritiesPassword
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
        binding.btnBack.setOnClickListener {
            it.findNavController().navigateUp()
        }
        val dataNama = args.namaLengkap
        val dataNoHp = args.noHp
        val dataSekolah = args.asalSekolah

        Snackbar.make(
            binding.root,
            "Nama: $dataNama, noHp = $dataNoHp, sekolah: $dataSekolah",
            Snackbar.LENGTH_LONG
        ).show()

        binding.btnDaftar.setOnClickListener {
            val pass1 = binding.edtPassword.editText?.text.toString()
            val pass2 = binding.edtPasswordKonfirm.editText?.text.toString()

            if (checkTextViewEmpty(binding.edtUsername, "Username") &&
                checkTextViewEmpty(binding.edtPassword, "Password") &&
                checkTextViewEmpty(binding.edtPasswordKonfirm, "Konfirmasi") &&
                checkSimilaritiesPassword(pass1, pass2)
            ) {
                view.findNavController().navigate(R.id.action_nextRegisterFragment_to_loginFragment)
            }
        }
        binding.edtUsername.editText?.addTextChangedListener {
            val username = binding.edtUsername
            val value = username.editText?.text.toString()
            setError(username, value.isEmpty(), "Username tidak boleh kosong")
        }


        binding.edtPasswordKonfirm.editText?.addTextChangedListener {
            val password1 = binding.edtPassword.editText?.text.toString()
            val password2 = binding.edtPasswordKonfirm.editText?.text.toString()
            val message = "Konfirmasi password tidak sesuai"
            setError(
                binding.edtPasswordKonfirm,
                !checkSimilaritiesPassword(password1, password2),
                message
            )

        }

        binding.edtPassword.editText?.addTextChangedListener {
            val message = getString(R.string.tooltips_password)
            setError(binding.edtPassword, !checkPasswordStrength(it.toString()), message)
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