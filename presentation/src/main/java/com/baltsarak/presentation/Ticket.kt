package com.baltsarak.presentation

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: Int,
    val departureDate: Int,
    val arrivalDate: Int,
    val departureAirport: String,
    val arrivalAirport: String,
    val hasTransfer: Boolean
)
