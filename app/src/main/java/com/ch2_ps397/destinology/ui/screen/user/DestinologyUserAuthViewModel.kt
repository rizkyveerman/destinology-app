package com.ch2_ps397.destinology.ui.screen.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.data.repository.UserRepository
import com.ch2_ps397.destinology.core.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class DestinologyUserAuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _resource: MutableStateFlow<Resource<Any>> = MutableStateFlow(Resource.Idle)
    val resource: MutableStateFlow<Resource<Any>> = _resource

    fun loginUser(email: String, password: String, onSubmit: (res: Int) -> Unit) {
        viewModelScope.launch {
            try {
                _resource.value = Resource.Loading
                val res = userRepository.loginUser(email, password)
                onSubmit(res)
            } catch (e: Exception) {

            }
        }
    }

    fun registerUser(
        email: String,
        fullname: String,
        username: String,
        password: String,
        navController: NavController
    ) {
        viewModelScope.launch {
            try {
                _resource.value = Resource.Loading
                val res = userRepository.createAccountUser(
                    email = email,
                    fullName = fullname,
                    username = username,
                    password = password
                )
            } catch (e: Exception) {

            }
        }
    }
}