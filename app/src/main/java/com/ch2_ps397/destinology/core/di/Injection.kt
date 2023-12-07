package com.ch2_ps397.destinology.core.di

import android.content.Context
import com.ch2_ps397.destinology.core.data.repository.ItineraryRepository
import com.ch2_ps397.destinology.core.data.source.local.UserPreferences
import com.ch2_ps397.destinology.core.data.source.local.dataStore
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiConfig
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context) : ItineraryRepository {
        val userPreferences = UserPreferences.getInstance(context.dataStore)
        val token = runBlocking { userPreferences.getToken().firstOrNull() }
        val apiService = runBlocking { ApiConfig.getApiService(token) }
        return ItineraryRepository(token, userPreferences, apiService)
    }
}