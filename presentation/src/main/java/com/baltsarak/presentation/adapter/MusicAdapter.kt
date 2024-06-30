package com.baltsarak.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.baltsarak.presentation.MusicOffer
import com.baltsarak.presentation.databinding.MusicItemBinding

class MusicAdapter :
    ListAdapter<MusicOffer, MusicViewHolder>(MusicDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = MusicItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val offer = getItem(position)
        with(holder.binding) {
            title.text = offer.name
            city.text = offer.city
            price.text = offer.price
        }
    }
}