package com.ch2_ps397.destinology.core.data.source.remote.network

import com.ch2_ps397.destinology.core.data.source.remote.response.FileUploadResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.ItineraryResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {
    @GET("itinerary")
    fun generateNewItinerary(city: String, duration: String, budget: String) : Call<ItineraryResponse>

    @GET("itinerary")
    fun getAllItinerary() : Call<ItineraryResponse>

    @GET("itinerary/{id}")
    fun getItinerary(@Path("id") id: String): Call<ItineraryResponse>

    // TODO change the API response here
    @Multipart
    @POST("stories/guest/")
    suspend fun scanLandmark(@Part file: MultipartBody.Part) : Call<FileUploadResponse>
}