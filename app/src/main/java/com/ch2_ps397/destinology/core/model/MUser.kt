package com.ch2_ps397.destinology.core.model

data class MUser(
    var email: String = "",
    var full_name: String = "",
    var password: String = "",
    var username: String = "",
)

data class MCreateUserResponse(
    var code: Int = 0,
    var message: String? = "",
)
