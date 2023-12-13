package com.ch2_ps397.destinology.core.di

import android.content.Context
import com.ch2_ps397.destinology.core.data.repository.ItineraryRepository
import com.ch2_ps397.destinology.core.data.repository.LandmarkRepository
import com.ch2_ps397.destinology.core.data.source.local.UserPreferences
import com.ch2_ps397.destinology.core.data.source.local.dataStore
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiConfig
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideItineraryRepository(context: Context) : ItineraryRepository {
        val userPreferences = UserPreferences.getInstance(context.dataStore)
        val token = runBlocking { userPreferences.getToken().firstOrNull() }
        val apiService = runBlocking { ApiConfig.getApiService(token) }
        return ItineraryRepository(token, userPreferences, apiService)
    }

    fun provideLandmarkRepository(context: Context) : LandmarkRepository {
        val userPreferences = UserPreferences.getInstance(context.dataStore)
        val token = runBlocking { userPreferences.getToken().firstOrNull() }
        val apiService = runBlocking { ApiConfig.getApiService(token) }
        return LandmarkRepository(token, apiService)
    }
}