package com.baltsarak.domain

import com.baltsarak.domain.entities.MusicOffer
import com.baltsarak.domain.entities.Ticket
import com.baltsarak.domain.entities.TicketOffer

interface TicketRepository {

    suspend fun getMusicOffers(): List<MusicOffer>

    suspend fun getTicketsOffers(): List<TicketOffer>

    suspend fun getAllTickets(): List<Ticket>

    suspend fun saveTextInCache(text: String)

    suspend fun getTextFromCache(): String
}