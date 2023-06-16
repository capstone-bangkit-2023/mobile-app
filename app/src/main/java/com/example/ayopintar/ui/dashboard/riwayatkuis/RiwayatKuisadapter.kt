package com.example.ayopintar.ui.dashboard.riwayatkuis

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ayopintar.R
import com.example.ayopintar.api.response.DataItemNilai
import com.example.ayopintar.databinding.CardRiwayatNilaiBinding


class RiwayatKuisadapter(private val data: List<DataItemNilai?>) :
    RecyclerView.Adapter<RiwayatKuisadapter.ViewHolder>() {

    class ViewHolder(binding: CardRiwayatNilaiBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivImage
        val mapel = binding.tvMataPelajaran
        val pendidikan = binding.tvPendidikan
        val nilai = binding.tvNilai
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardRiwayatNilaiBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataMapel = data.get(position)?.mataPelajaran
        val dataPhoto = data.get(position)?.linkFoto ?: ""
        val dataPendidikan = data.get(position)?.pendidikan
        val dataNilai = data.get(position)?.nilai



        with(holder) {
            mapel.text = dataMapel
            pendidikan.text = dataPendidikan
            if (dataNilai != null) {
                if (dataNilai < 60 ) nilai.setTextColor(Color.RED)
                nilai.text = dataNilai.toString()

            }


            Glide.with(itemView.context)
                .load(dataPhoto)
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)

        }

    }

}