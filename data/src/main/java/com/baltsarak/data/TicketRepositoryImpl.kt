package com.baltsarak.data

import android.util.Log
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
        return try {
            val musicOffers = service.getMusicOffers().musicList
            musicOffers.map { mapper.mapMusicOffer(it) }
        } catch (e: Exception) {
            Log.e("TicketRepositoryImpl", "Error fetching music offers", e)
            emptyList()
        }
    }

    override suspend fun getTicketsOffers(): List<TicketOffer> {
        return try {
            val ticketOffers = service.getTicketsOffers().ticketList
            ticketOffers.map { mapper.mapTicketOffer(it) }
        } catch (e: Exception) {
            Log.e("TicketRepositoryImpl", "Error fetching ticket offers", e)
            emptyList()
        }
    }

    override suspend fun getAllTickets(): List<Ticket> {
        return try {
            val ticketsList = service.getAllTickets().ticketList ?: emptyList()
            ticketsList.map { mapper.mapTicket(it) }
        } catch (e: Exception) {
            Log.e("TicketRepositoryImpl", "Error fetching all tickets", e)
            emptyList()
        }
    }

    override suspend fun saveTextInCache(text: String) {
        preferenceHelper.saveText(text)
    }

    override suspend fun getTextFromCache(): String {
        return preferenceHelper.loadText() ?: ""
    }
}