package com.ch2_ps397.destinology.core.data.repository

import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService

class UserRepository(
    private val token: String?,
    private val apiService: ApiService
) {
}