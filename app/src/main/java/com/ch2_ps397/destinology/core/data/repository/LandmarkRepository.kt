package com.ch2_ps397.destinology.core.data.repository

import android.content.Context
import android.graphics.Bitmap
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService
import com.ch2_ps397.destinology.core.model.MLandmark
import com.ch2_ps397.destinology.ui.screen.scan.bitmapToFile
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody

class LandmarkRepository(
    private val apiService: ApiService
) {
    private var scanResponse: MLandmark? = MLandmark()

    suspend fun scanLandmark(bitmap: Bitmap, applicationContext: Context) : Flow<MLandmark> {
        val file = bitmapToFile(bitmap, applicationContext)
        val requestFile = RequestBody.create("image/jpeg".toMediaTypeOrNull(), file)
        val filePart = MultipartBody.Part.createFormData("file", file.name, requestFile)

        try {
            val response = apiService.scanLandmark(filePart)
            scanResponse = MLandmark(
                fact = response.fact,
                desc = response.desc,
                nama = response.nama
            )
        } catch (e: Exception) {
            scanResponse = MLandmark(
                errorMessage = e.message.toString()
            )
        }

        return flowOf(scanResponse!!)
    }
}