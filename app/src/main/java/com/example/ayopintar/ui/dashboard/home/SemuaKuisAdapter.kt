package com.example.ayopintar.ui.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ayopintar.R
import com.example.ayopintar.api.response.PelajaranDummyResponse
import com.example.ayopintar.databinding.CardSemuaKuisBinding

class SemuaKuisAdapter(private val data: ArrayList<PelajaranDummyResponse>):
    RecyclerView.Adapter<SemuaKuisAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ViewHolder(binding: CardSemuaKuisBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivImage
        val mapel = binding.tvMataPelajaran
        val pendidikan = binding.tvKelas

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardSemuaKuisBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (dataMapel, dataPendidikan, dataPhoto ) = data[position]
        with(holder){
            mapel.text = dataMapel
            pendidikan.text = dataPendidikan
            Glide.with(itemView.context)
                .load(dataPhoto)
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)
            itemView.setOnClickListener { onItemClickCallback.onItemClicked(data[adapterPosition]) }
        }

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: PelajaranDummyResponse)
    }
}