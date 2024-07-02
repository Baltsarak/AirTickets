package com.baltsarak.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TicketDto(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("badge")
    @Expose
    val badge: String?,
    @SerializedName("price")
    @Expose
    val price: PriceDto,
    @SerializedName("departure")
    @Expose
    val departure: DepartureDto,
    @SerializedName("arrival")
    @Expose
    val arrival: ArrivalDto,
    @SerializedName("has_transfer")
    @Expose
    val hasTransfer: Boolean
)
