package com.ch2_ps397.destinology.ui.screen.user

import androidx.lifecycle.ViewModel
import com.ch2_ps397.destinology.core.data.repository.UserRepository

class DestinologyUserAuthViewModel(private val userRepositoyr: UserRepository) : ViewModel() {
    fun signInUser(email: String, password: String) {}
    fun registerUser(name: String, email: String, password: String) {}
}