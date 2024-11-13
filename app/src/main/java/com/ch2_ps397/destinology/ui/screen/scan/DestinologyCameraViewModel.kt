package com.ch2_ps397.destinology.ui.screen.scan

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.data.repository.LandmarkRepository
import com.ch2_ps397.destinology.core.model.MLandmark
import com.ch2_ps397.destinology.core.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DestinologyCameraViewModel(
    private val landmarkRepository: LandmarkRepository
) : ViewModel() {
    private val _bitmap: MutableStateFlow<Resource<Bitmap>> = MutableStateFlow(Resource.Idle)
    val bitmap = _bitmap

    private val _resource: MutableStateFlow<Resource<MLandmark>> = MutableStateFlow(Resource.Idle)
    val resource = _resource

    fun onTakePhoto(bitmap: Bitmap) {
        _bitmap.value = Resource.Success(bitmap)
    }

    fun getImageFromGallery(bitmap: Bitmap) {
        _bitmap.value = Resource.Success(bitmap)
    }

    fun uploadImage(bitmap: Bitmap, applicationContext: Context, navController: NavController) {
        viewModelScope.launch {
            _resource.value = Resource.Loading
            landmarkRepository.scanLandmark(bitmap, applicationContext)
                .catch { cause: Throwable ->
                    _resource.value = Resource.Error("Landmark tidak diketahui")
                }
                .collect { landmark ->
                    _resource.value = Resource.Success(landmark)
                    // TODO Go to Landmark detail
                }
        }
    }
}