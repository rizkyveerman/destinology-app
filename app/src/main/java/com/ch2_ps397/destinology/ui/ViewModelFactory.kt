package com.ch2_ps397.destinology.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ch2_ps397.destinology.core.data.repository.ItineraryRepository
import com.ch2_ps397.destinology.core.data.repository.LandmarkRepository
import com.ch2_ps397.destinology.core.data.repository.UserRepository
import com.ch2_ps397.destinology.ui.screen.scan.DestinologyCameraViewModel
import com.ch2_ps397.destinology.ui.screen.recommendation.DestinologyRecommendationViewModel
import com.ch2_ps397.destinology.ui.screen.splash.DestinologySplashViewModel
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserAuthViewModel

class ViewModelFactory(
    private val itineraryRepository: ItineraryRepository,
    private val landmarkRepository: LandmarkRepository,
    private val userRepository: UserRepository
): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DestinologyCameraViewModel::class.java)) {
            return DestinologyCameraViewModel(landmarkRepository) as T
        } else if(modelClass.isAssignableFrom(DestinologyRecommendationViewModel::class.java)) {
            return DestinologyRecommendationViewModel(itineraryRepository, savedStateHandle = SavedStateHandle()) as T
        } else if(modelClass.isAssignableFrom(DestinologyUserAuthViewModel::class.java)) {
            return DestinologyUserAuthViewModel(userRepository) as T
        } else if(modelClass.isAssignableFrom(DestinologySplashViewModel::class.java)) {
            return DestinologySplashViewModel(userRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}