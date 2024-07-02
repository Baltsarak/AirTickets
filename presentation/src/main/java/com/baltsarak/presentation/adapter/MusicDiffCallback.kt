package com.baltsarak.presentation.adapter

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.baltsarak.domain.entities.MusicOffer

object MusicDiffCallback : ItemCallback<MusicOffer>() {
    override fun areItemsTheSame(oldItem: MusicOffer, newItem: MusicOffer): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MusicOffer, newItem: MusicOffer): Boolean {
        return oldItem == newItem
    }
}