package com.ch2_ps397.destinology.core.data.source.remote.network

import com.ch2_ps397.destinology.core.data.source.remote.response.ItineraryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("itinerary")
    fun generateNewItinerary() : Call<ItineraryResponse>

    @GET("itinerary")
    fun getAllItinerary() : Call<ItineraryResponse>

    @GET("itinerary/{id}")
    fun getItinerary(@Path("id") id: String): Call<ItineraryResponse>
}