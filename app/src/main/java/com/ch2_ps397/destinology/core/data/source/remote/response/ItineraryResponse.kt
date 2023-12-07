package com.ch2_ps397.destinology.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ItineraryResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("address")
    val address: String,
)