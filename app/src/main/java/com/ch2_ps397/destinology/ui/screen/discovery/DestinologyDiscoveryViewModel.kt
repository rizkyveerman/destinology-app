package com.ch2_ps397.destinology.ui.screen.discovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ch2_ps397.destinology.core.data.repository.ItineraryRepository
import kotlinx.coroutines.launch

class DestinologyDiscoveryViewModel(
    private val itineraryRepository: ItineraryRepository
): ViewModel() {
    fun getPlaceByCategory() {
        viewModelScope.launch {

        }
    }
}