package com.ch2_ps397.destinology.core.utils

sealed class Resource<out T: Any?> {
    data class Success<T>(val data: T?) : Resource<T>()
    object Loading : Resource<Nothing>()
    data class Error<T>(val message: String) : Resource<T>()
}