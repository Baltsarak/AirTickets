package com.baltsarak.presentation

import androidx.recyclerview.widget.DiffUtil.ItemCallback

object MusicDiffCallback : ItemCallback<MusicOffer>() {
    override fun areItemsTheSame(oldItem: MusicOffer, newItem: MusicOffer): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: MusicOffer, newItem: MusicOffer): Boolean {
        return oldItem == newItem
    }
}