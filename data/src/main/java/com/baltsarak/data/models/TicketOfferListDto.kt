package com.baltsarak.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TicketOfferListDto(
    @SerializedName("offers")
    @Expose
    val ticketList: List<TicketOfferDto>
)
