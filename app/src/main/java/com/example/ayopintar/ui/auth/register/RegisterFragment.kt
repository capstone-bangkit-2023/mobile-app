package com.example.ayopintar.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ayopintar.databinding.FragmentRegisterBinding
import com.example.ayopintar.utils.InputValidate.checkEmpty
import com.google.android.material.textfield.TextInputLayout

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
            Pair(binding.edtNohp, "Nomor HP")
        )

        textInputLayouts.forEach { (textInputLayout, fieldName) ->
            textInputLayout.errorIconDrawable = null
            textInputLayout.editText?.setOnFocusChangeListener { _, hasFocus ->
                if (!hasFocus) {
                    checkEmpty(textInputLayout, fieldName)
                }
            }
            textInputLayout.editText?.addTextChangedListener {
                checkEmpty(textInputLayout, fieldName)
            }
        }

        binding.btnNext.setOnClickListener {
            val namaLengkap = binding.edtName.editText?.text.toString().trim()
            val asalSekolah = binding.edtAsalSekolah.editText?.text.toString().trim()
            val noHp = binding.edtNohp.editText?.text.toString().trim()

            if (checkTextViewsEmpty(textInputLayouts)) {
                // Lanjutkan ke tindakan berikutnya jika semua TextView tidak kosong
                val toNextRegisterFragment = RegisterFragmentDirections.actionRegisterFragmentToNextRegisterFragment()
                toNextRegisterFragment.namaLengkap = namaLengkap
                toNextRegisterFragment.noHp = noHp
                toNextRegisterFragment.asalSekolah = asalSekolah
                view.findNavController().navigate(toNextRegisterFragment)
            }
        }
    }

    private fun checkTextViewsEmpty(textInputLayouts: List<Pair<TextInputLayout, String>>): Boolean {
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
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}