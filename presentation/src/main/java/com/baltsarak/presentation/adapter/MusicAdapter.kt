package com.baltsarak.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.baltsarak.domain.entities.MusicOffer
import com.baltsarak.presentation.R
import com.baltsarak.presentation.databinding.MusicCardBinding

class MusicAdapter :
    ListAdapter<MusicOffer, MusicViewHolder>(MusicDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = MusicCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val offer = getItem(position)
        with(holder.binding) {
            when (offer.id) {
                1 -> artistImage.setImageResource(R.drawable.artist1)
                2 -> artistImage.setImageResource(R.drawable.artist2)
                3 -> artistImage.setImageResource(R.drawable.artist3)
            }
            title.text = offer.title
            city.text = offer.town
            price.text = offer.price.toString()
        }
    }
}