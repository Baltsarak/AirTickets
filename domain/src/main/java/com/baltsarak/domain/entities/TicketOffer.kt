package com.baltsarak.domain.entities

data class TicketOffer(
    val id: Int,
    val title: String,
    val timeRange: String,
    val price: String
)