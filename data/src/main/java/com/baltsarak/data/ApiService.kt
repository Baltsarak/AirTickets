package com.baltsarak.data

import com.baltsarak.data.models.MusicOfferListDto
import com.baltsarak.data.models.TicketListDto
import com.baltsarak.data.models.TicketOfferListDto
import retrofit2.http.GET

interface ApiService {

    @GET("u/0/uc?id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav&export=download")
    suspend fun getMusicOffers(): MusicOfferListDto

    @GET("u/0/uc?id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta&export=download")
    suspend fun getTicketsOffers(): TicketOfferListDto

    @GET("uc?export=download&id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
    suspend fun getAllTickets(): TicketListDto
}