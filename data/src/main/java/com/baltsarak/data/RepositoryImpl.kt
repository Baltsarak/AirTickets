package com.baltsarak.data

import com.baltsarak.domain.TicketRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TicketRepositoryImpl(
    private val service: ApiService
) : TicketRepository {

    constructor() : this(
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://run.mocky.io/v3/")
            .build()
            .create(ApiService::class.java)
    )

    override suspend fun getMusicOffers() {
        TODO("Not yet implemented")
    }

    override suspend fun getTicketsOffers() {
        TODO("Not yet implemented")
    }

    override suspend fun getAllTickets() {
        TODO("Not yet implemented")
    }
}