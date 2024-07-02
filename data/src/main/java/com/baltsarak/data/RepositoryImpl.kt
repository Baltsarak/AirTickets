package com.baltsarak.data

import com.baltsarak.domain.TicketRepository
import javax.inject.Inject

class TicketRepositoryImpl @Inject constructor(
    private val service: ApiService,
    private val preferenceHelper: PreferenceHelper
) : TicketRepository {

    override suspend fun getMusicOffers() {
        TODO("Not yet implemented")
    }

    override suspend fun getTicketsOffers() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTickets() {
        TODO("Not yet implemented")
    }

    override suspend fun saveTextInCache(text: String) {
        preferenceHelper.saveText(text)
    }

    override suspend fun getTextFromCache(): String {
        return preferenceHelper.loadText() ?: ""
    }
}