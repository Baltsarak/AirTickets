package com.baltsarak.domain

interface TicketRepository {

    suspend fun getMusicOffers()

    suspend fun getTicketsOffers()

    suspend fun getAllTickets()

    suspend fun saveTextInCache(text: String)

    suspend fun getTextFromCache(): String
}