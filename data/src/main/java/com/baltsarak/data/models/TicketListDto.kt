package com.baltsarak.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TicketListDto(
    @SerializedName("tickets")
    @Expose
    val ticketList: List<TicketDto>
)
