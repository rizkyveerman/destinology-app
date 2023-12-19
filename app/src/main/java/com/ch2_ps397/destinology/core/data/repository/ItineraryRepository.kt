package com.ch2_ps397.destinology.core.data.repository

import android.util.Log
import com.ch2_ps397.destinology.core.data.source.local.UserPreferences
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService
import com.ch2_ps397.destinology.core.data.source.remote.response.GenerateItineraryResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.ItineraryItem
import com.ch2_ps397.destinology.core.model.MGenerateItinerary
import com.ch2_ps397.destinology.core.model.MItinerary
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItineraryRepository(
    private val token: String?,
    private val userPreferences: UserPreferences,
    private val apiService: ApiService
) {

    private val itineraryList = mutableListOf<MItinerary>()

    suspend fun generateNewItinerary(city: String, duration: Int, budget: Int): Flow<List<MItinerary>> {
        val generateItinerary = MGenerateItinerary(city, duration, budget)
        val client = apiService.generateNewItinerary(generateItinerary)

        client.itinerary.map {
            itineraryItem ->
            itineraryList.add(
                MItinerary(
                placeName = itineraryItem.placeName,
                category = itineraryItem.category,
                day = itineraryItem.day,
                rating = itineraryItem.rating.toFloat(),
                price = itineraryItem.price,
            )
            )
        }
        return  flowOf(itineraryList)
    }
}