package com.baltsarak.domain

interface TicketRepository {

    suspend fun getMusicOffers()

    suspend fun getTicketsOffers()

    suspend fun getAllTickets()
}