package com.baltsarak.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PriceDto(
    @SerializedName("value")
    @Expose
    val value: Int
)