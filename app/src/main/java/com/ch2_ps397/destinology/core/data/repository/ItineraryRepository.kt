package com.ch2_ps397.destinology.core.data.repository

import com.ch2_ps397.destinology.core.data.source.local.UserPreferences
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService
import com.ch2_ps397.destinology.core.data.source.remote.response.ItineraryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class ItineraryRepository(
    private val token: String?,
    private val userPreferences: UserPreferences,
    private val apiService: ApiService
) {

    fun getToken() = token

//    suspend fun getAllItinerary(token: String): Response<ItineraryRepository> {
//        val client = apiService.getAllItinerary()
//
//        return client.awaitResponse()
//    }

    suspend fun getItineraryDetail(id:String): Response<ItineraryResponse> {
        val client = apiService.getItinerary(id)
        client.clone().enqueue(object : Callback<ItineraryResponse> {
            override fun onResponse(
                call: Call<ItineraryResponse>,
                response: Response<ItineraryResponse>
            ) {
//                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<ItineraryResponse>, t: Throwable) {
//                TODO("Not yet implemented")
            }
        })

        return client.awaitResponse()
    }
}