package com.ch2_ps397.destinology.core.data.source.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class UserPreferences private constructor(private val dataStore: DataStore<Preferences>) {
    private val userToken = stringPreferencesKey("user_token")

    fun getToken(): Flow<String?> {
        return dataStore.data.map { preferences ->
            preferences[userToken]
        }
    }

    suspend fun deleteToken() {
        dataStore.edit { preferences ->
            preferences.remove(userToken)
        }
    }

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[userToken] = token
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreferences? = null

        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}