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

            if (checkTextViewEmpty(binding.edtUsername, "Username") &&
                checkTextViewEmpty(binding.edtPassword, "Password") &&
                checkTextViewEmpty(binding.edtPasswordKonfirm, "Konfirmasi")
            ) {

                view.findNavController().navigate(R.id.action_nextRegisterFragment_to_loginFragment)
            }
        }


        binding.edtPasswordKonfirm.editText?.addTextChangedListener {
            val password1 = binding.edtPassword.editText?.text.toString()
            val password2 = binding.edtPasswordKonfirm.editText?.text.toString()

            if (!checkSimilaritiesPassword(password1, password2)) {
                binding.edtPasswordKonfirm.error = "Konfirmasi password tidak sesuai"
                binding.edtPasswordKonfirm.errorIconDrawable = null
                binding.btnDaftar.isEnabled = false
            } else {
                binding.edtPasswordKonfirm.error = null
                binding.btnDaftar.isEnabled = true
            }
        }

        binding.edtPassword.editText?.addTextChangedListener {
                if (!checkPasswordStrength(it.toString())){
                    binding.edtPassword.errorIconDrawable = null
                    binding.edtPassword.error = getString(R.string.tooltips_password)
                    binding.btnDaftar.isEnabled = false
                }else{
                        binding.edtPassword.error = null
                    binding.btnDaftar.isEnabled = true
                }
            }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}