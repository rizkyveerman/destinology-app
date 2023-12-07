package com.ch2_ps397.destinology.ui.screen.camera

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class DestinologyCameraScreenViewModel: ViewModel() {
    private val _bitmaps = MutableStateFlow<List<Bitmap>>(emptyList())
    val bitmaps = _bitmaps

    private val _isLoading = MutableStateFlow<Boolean>(false)
    val isLoading = _isLoading

    fun onTakePhoto(bitmap: Bitmap) {
        _bitmaps.value += bitmap

        // TODO upload bitmap to server
    }
}