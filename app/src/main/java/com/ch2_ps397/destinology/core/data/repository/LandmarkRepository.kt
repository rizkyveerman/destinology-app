package com.ch2_ps397.destinology.core.data.repository

import android.util.Log
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService
import com.ch2_ps397.destinology.core.data.source.remote.response.FileUploadResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LandmarkRepository(
    private val token: String?,
    private val apiService: ApiService
) {
    suspend fun scanLandmark(multipartBodyPart: MultipartBody.Part) {
        val client = apiService.scanLandmark(multipartBodyPart)

        client.clone().enqueue(object : Callback<FileUploadResponse> {
            override fun onResponse(
                call: Call<FileUploadResponse>,
                response: Response<FileUploadResponse>
            ) {
                Log.i("SCAN_LANDMARK", "onResponse: ${response.isSuccessful}")
            }
            override fun onFailure(call: Call<FileUploadResponse>, t: Throwable) {
                Log.e("SCAN_LANDMARK", "onResponse: ${t.message}")
            }
        })
    }
}