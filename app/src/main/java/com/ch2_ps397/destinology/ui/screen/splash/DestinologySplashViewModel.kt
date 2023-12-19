package com.ch2_ps397.destinology.ui.screen.splash

import androidx.lifecycle.ViewModel
import com.ch2_ps397.destinology.core.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow

class DestinologySplashViewModel(
    private val userRepository: UserRepository
): ViewModel() {
    private val _userToken: MutableStateFlow<String?> = MutableStateFlow(null)
    val userToken: MutableStateFlow<String?> = _userToken

    init {
        getToken()
    }
    private fun getToken() {
        _userToken.value = userRepository.getUserToken()
    }
}