package com.baltsarak.domain.entities

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: Int,
    val departureTime: String,
    val arrivalTime: String,
    val duration: String,
    val departureAirport: String,
    val arrivalAirport: String,
    val hasTransfer: Boolean
)
