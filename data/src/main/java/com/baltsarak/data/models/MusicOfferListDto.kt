package com.baltsarak.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MusicOfferListDto(
    @SerializedName("offers")
    @Expose
    val musicList: List<MusicOfferDto>
)
