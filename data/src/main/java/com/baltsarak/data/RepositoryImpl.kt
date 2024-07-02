package com.baltsarak.data

import com.baltsarak.domain.TicketRepository
import com.baltsarak.domain.entities.MusicOffer
import com.baltsarak.domain.entities.Ticket
import com.baltsarak.domain.entities.TicketOffer
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    private val service: ApiService,
    private val preferenceHelper: PreferenceHelper,
    private val mapper: Mapper
) : TicketRepository {

    override suspend fun getMusicOffers(): List<MusicOffer> {
        val musicOffers = service.getMusicOffers().musicList
        return musicOffers.map { mapper.mapMusicOffer(it) }
    }

    override suspend fun getTicketsOffers(): List<TicketOffer> {
        val ticketOffers = service.getTicketsOffers().ticketList
        return ticketOffers.map { mapper.mapTicketOffer(it) }
    }

    override suspend fun getAllTickets(): List<Ticket> {
        val ticketsList = service.getAllTickets().ticketList
        return ticketsList.map { mapper.mapTicket(it) }
    }

    override suspend fun saveTextInCache(text: String) {
        preferenceHelper.saveText(text)
    }

    override suspend fun getTextFromCache(): String {
        return preferenceHelper.loadText() ?: ""
    }
}