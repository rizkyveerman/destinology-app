package com.ch2_ps397.destinology.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ch2_ps397.destinology.core.data.repository.ItineraryRepository
import com.ch2_ps397.destinology.ui.screen.camera.DestinologyCameraScreenViewModel

class ViewModelFactory(
    private val itineraryRepository: ItineraryRepository
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DestinologyCameraScreenViewModel::class.java)) {
            return DestinologyCameraScreenViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}