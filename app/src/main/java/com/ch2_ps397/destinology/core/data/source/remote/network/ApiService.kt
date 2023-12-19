package com.ch2_ps397.destinology.core.data.source.remote.network

import com.ch2_ps397.destinology.core.data.source.remote.response.DestinologyCreateUserResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.DestinologyLoginUserResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.FileUploadResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.ItineraryResponse
import com.ch2_ps397.destinology.core.model.MUser
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path


interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("auth/signup")
    fun createAccountUser(
        @Body user: MUser
    ) : Call<DestinologyCreateUserResponse>

    @Headers("Content-Type: application/json")
    @POST("auth/signin")
    fun loginUser(
        @Body user: MUser
    ) : Call<DestinologyLoginUserResponse>

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