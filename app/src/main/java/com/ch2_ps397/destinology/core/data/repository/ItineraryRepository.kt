package com.ch2_ps397.destinology.core.data.repository

import com.ch2_ps397.destinology.core.data.source.local.UserPreferences
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService
import com.ch2_ps397.destinology.core.data.source.remote.response.ItineraryResponse
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
    private var itineraryDetails = MItinerary()
    private var newItinerary = MItinerary()

    fun getToken() = token

    suspend fun getAllItinerary(): Flow<List<MItinerary>>{
        val client = apiService.getAllItinerary()
        client.clone().enqueue(object : Callback<ItineraryResponse> {
            override fun onResponse(
                call: Call<ItineraryResponse>,
                response: Response<ItineraryResponse>
            ) {
                if (response.isSuccessful) {
                    itineraryList.add(
                        MItinerary(
                            id = response.body()?.id!!,
                            name = response.body()?.name!!,
                            description = response.body()?.description!!,
                            address = response.body()?.address!!,
                        )
                    )
                }
            }

            override fun onFailure(call: Call<ItineraryResponse>, t: Throwable) {
//                TODO("Not yet implemented")
            }
        })

        return flowOf(itineraryList)
    }

suspend fun generateNewItinerary(city: String, duration: String, budget: String): Flow<MItinerary> {
        val client = apiService.generateNewItinerary(city, duration, budget)
        client.clone().enqueue(object : Callback<ItineraryResponse> {
            override fun onResponse(
                call: Call<ItineraryResponse>,
                response: Response<ItineraryResponse>
            ) {
                if (response.isSuccessful) {
                    newItinerary = MItinerary(
                        id = response.body()?.id!!,
                        name = response.body()?.name!!,
                        description = response.body()?.description!!,
                        address = response.body()?.address!!,
                    )
                }
            }

            override fun onFailure(call: Call<ItineraryResponse>, t: Throwable) {
//                TODO("Not yet implemented")
            }
        })
        return  flowOf(newItinerary)
    }

    suspend fun getItineraryDetail(id:String): Flow<MItinerary> {
        val client = apiService.getItinerary(id)
        client.clone().enqueue(object : Callback<ItineraryResponse> {
            override fun onResponse(
                call: Call<ItineraryResponse>,
                response: Response<ItineraryResponse>
            ) {
                if (response.isSuccessful) {
                    itineraryDetails = MItinerary(
                        id = response.body()?.id!!,
                        name = response.body()?.name!!,
                        description = response.body()?.description!!,
                        address = response.body()?.address!!,
                    )
                }
            }

            override fun onFailure(call: Call<ItineraryResponse>, t: Throwable) {
//                TODO("Not yet implemented")
            }
        })

        return flowOf(itineraryDetails)
    }
}