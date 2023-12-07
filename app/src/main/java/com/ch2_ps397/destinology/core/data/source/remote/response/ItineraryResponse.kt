package com.ch2_ps397.destinology.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ItineraryResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("id")
    val name: String,

    @field:SerializedName("id")
    val description: String,

    @field:SerializedName("id")
    val address: String,
)