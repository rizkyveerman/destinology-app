package com.ch2_ps397.destinology.ui.screen.recommendation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ch2_ps397.destinology.core.data.repository.ItineraryRepository
import com.ch2_ps397.destinology.core.model.MItinerary
import com.ch2_ps397.destinology.core.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DestinologyRecommendationViewModel(
    private val itineraryRepository: ItineraryRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val itinerary = savedStateHandle.getStateFlow("itinerary", null)
    private val _resource: MutableStateFlow<Resource<MItinerary>> = MutableStateFlow(Resource.Loading)
    val resource: MutableStateFlow<Resource<MItinerary>> = _resource

    fun generateNewItinerary() {
        viewModelScope.launch {
            itineraryRepository.generateNewItinerary()
                .catch { cause ->
                    _resource.value = Resource.Error(cause.message.toString())
                }
                .collect { data ->
                    savedStateHandle["itinerary"] = data
                    _resource.value = Resource.Success(data)
                }
        }
    }
}