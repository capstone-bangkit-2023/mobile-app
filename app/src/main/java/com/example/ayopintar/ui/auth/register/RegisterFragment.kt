package com.example.ayopintar.ui.auth.register

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ayopintar.databinding.FragmentRegisterBinding
import com.example.ayopintar.utils.InputValidate

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            it.findNavController().navigateUp()
        }

        val textInputLayouts = listOf(
            Pair(binding.edtName, "Nama Lengkap"),
            Pair(binding.edtAsalSekolah, "Asal Sekolah"),
            Pair(binding.edtEmail, "Email")
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

        binding.btnNext.setOnClickListener {
            val namaLengkap = binding.edtName.editText?.text.toString().trim()
            val asalSekolah = binding.edtAsalSekolah.editText?.text.toString().trim()
            val email = binding.edtEmail.editText?.text.toString().trim()

            if (InputValidate.checkTextViewsEmpty(textInputLayouts)) {
                // Lanjutkan ke tindakan berikutnya jika semua TextView tidak kosong
                val toNextRegisterFragment = RegisterFragmentDirections.actionRegisterFragmentToNextRegisterFragment()
                if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    toNextRegisterFragment.namaLengkap = namaLengkap
                    toNextRegisterFragment.email = email
                    toNextRegisterFragment.asalSekolah = asalSekolah
                    view.findNavController().navigate(toNextRegisterFragment)
                } else {
                    binding.edtEmail.error = "Format Email Tidak sesuai"
                }
            }
        }
    }

    /*private fun checkTextViewsEmpty(textInputLayouts: List<Pair<TextInputLayout, String>>): Boolean {
        var allFieldsNotEmpty = true

        for ((textInputLayout, fieldName) in textInputLayouts) {
            val text = textInputLayout.editText?.text.toString().trim()
            if (text.isEmpty()) {
                textInputLayout.error = "Field $fieldName tidak boleh kosong."
                allFieldsNotEmpty = false
            } else {
                textInputLayout.error = null
            }
        }
        return allFieldsNotEmpty
    }*/

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}