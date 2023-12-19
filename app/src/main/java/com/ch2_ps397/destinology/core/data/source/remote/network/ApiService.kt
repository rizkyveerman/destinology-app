package com.ch2_ps397.destinology.core.data.source.remote.network

import com.ch2_ps397.destinology.core.data.source.remote.response.DestinologyCreateUserResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.DestinologyLoginUserResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.FileUploadResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.GenerateItineraryResponse
import com.ch2_ps397.destinology.core.model.MGenerateItinerary
import com.ch2_ps397.destinology.core.model.MUser
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface ApiService {
    @POST("auth/signup")
    fun createAccountUser(@Body user: MUser) : Call<DestinologyCreateUserResponse>

    @POST("auth/signin")
    fun loginUser(@Body user: MUser) : Call<DestinologyLoginUserResponse>

    @POST("models/itinerary")
    suspend fun generateNewItinerary(@Body generateItinerary: MGenerateItinerary) : GenerateItineraryResponse

    // TODO change the API response here
    @Multipart
    @POST("stories/guest/")
    suspend fun scanLandmark(@Part file: MultipartBody.Part) : Call<FileUploadResponse>
}