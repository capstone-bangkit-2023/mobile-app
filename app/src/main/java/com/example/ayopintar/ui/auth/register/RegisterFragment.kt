package com.example.ayopintar.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.ayopintar.databinding.FragmentRegisterBinding
import com.example.ayopintar.utils.InputValidate.checkTextViewEmpty

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





        binding.btnNext.setOnClickListener {
            val namaLengkap = binding.edtName.editText?.text.toString()
            val asalSekolah = binding.edtAsalSekolah.editText?.text.toString()
            val noHp = binding.edtNohp.editText?.text.toString()


            if (checkTextViewEmpty(binding.edtName, "Nama Lengkap") &&
                checkTextViewEmpty(binding.edtAsalSekolah, "Asal Sekolah") &&
                checkTextViewEmpty(binding.edtNohp, "Nomor HP")) {
                // Lanjutkan ke tindakan berikutnya jika semua TextView tidak kosong
                val toNextRegisterFragment =
                    RegisterFragmentDirections.actionRegisterFragmentToNextRegisterFragment()
                toNextRegisterFragment.namaLengkap = namaLengkap
                toNextRegisterFragment.noHp = noHp
                toNextRegisterFragment.asalSekolah = asalSekolah
                view.findNavController().navigate(toNextRegisterFragment)
            }


        }
    }





    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}