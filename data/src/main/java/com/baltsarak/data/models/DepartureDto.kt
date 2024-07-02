package com.baltsarak.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DepartureDto(
    @SerializedName("town")
    @Expose
    val town: String,
    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("airport")
    @Expose
    val airport: String
)
