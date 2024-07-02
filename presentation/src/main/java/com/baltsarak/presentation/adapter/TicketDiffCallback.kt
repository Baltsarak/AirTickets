package com.baltsarak.presentation.adapter

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.baltsarak.presentation.Ticket

object TicketDiffCallback : ItemCallback<Ticket>() {
    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }
}