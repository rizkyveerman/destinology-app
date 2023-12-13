package com.ch2_ps397.destinology.ui.screen.camera

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ch2_ps397.destinology.core.data.repository.LandmarkRepository
import com.ch2_ps397.destinology.core.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class DestinologyCameraViewModel(
    private val landmarkRepository: LandmarkRepository
): ViewModel() {

    private val _bitmap: MutableStateFlow<Resource<Bitmap>> = MutableStateFlow(Resource.Idle)
    val bitmap = _bitmap

    fun onTakePhoto(bitmap: Bitmap) {
        _bitmap.value = Resource.Success(bitmap)
    }

    fun uploadImage(multipartBody: MultipartBody.Part) {
        Log.i("SCAN_LANDMARK", "send to API")
        viewModelScope.launch {
            landmarkRepository.scanLandmark(multipartBody)
        }
    }
}