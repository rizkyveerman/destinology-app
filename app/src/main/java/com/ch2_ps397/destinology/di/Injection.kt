package com.ch2_ps397.destinology.di

import com.ch2_ps397.destinology.repository.ItineraryRepository

object Injection {
    fun provideRepository() : ItineraryRepository {
        return ItineraryRepository()
    }
}