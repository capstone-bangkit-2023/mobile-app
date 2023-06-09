package com.example.ayopintar.ui.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ayopintar.R
import com.example.ayopintar.api.response.DataItem
import com.example.ayopintar.databinding.CardKuisPopulerBinding


class PopulerKuisAdapter(private val data: List<DataItem?>?) :
    RecyclerView.Adapter<PopulerKuisAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ViewHolder(binding: CardKuisPopulerBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivImage
        val mapel = binding.tvMataPelajaran
        val pendidikan = binding.tvKelas

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardKuisPopulerBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data!!.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataMapel = data?.get(position)?.mataPelajaran
        val dataPhoto = data?.get(position)?.linkFoto ?: ""
        with(holder) {
            mapel.text = dataMapel
            pendidikan.text = holder.itemView.context.getString(R.string.pendidikan)
            Glide.with(itemView.context)
                .load(dataPhoto)
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)
            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(data?.get(adapterPosition))
            }
        }

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItem?)
    }
}