package com.baltsarak.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.baltsarak.domain.entities.Ticket
import com.baltsarak.presentation.databinding.TicketCardBinding

class TicketAdapter :
    ListAdapter<Ticket, TicketViewHolder>(TicketDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketViewHolder {
        val binding = TicketCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TicketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TicketViewHolder, position: Int) {
        val ticket = getItem(position)
        with(holder.binding) {
            if(ticket.badge.isNullOrBlank()) {
                badge.visibility = View.GONE
            } else {
                badge.visibility = View.VISIBLE
                badge.text = ticket.badge
            }
            price.text = ticket.price.toString()
            departureTime.text = ticket.departureDate.toString()
            arrivalTime.text = ticket.arrivalDate.toString()
            travelTime.text = (ticket.arrivalDate - ticket.departureDate).toString()
            departureAirport.text = ticket.departureAirport
            arrivalAirport.text = ticket.arrivalAirport
            if(!ticket.hasTransfer) {
                transfersInfo.visibility = View.VISIBLE
            } else {
                transfersInfo.visibility = View.GONE
            }
        }
    }
}