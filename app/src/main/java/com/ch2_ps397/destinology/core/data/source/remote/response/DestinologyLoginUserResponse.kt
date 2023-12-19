package com.ch2_ps397.destinology.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DestinologyLoginUserResponse(

	@field:SerializedName("access_token")
	val accessToken: String,

	@field:SerializedName("refresh_token")
	val refreshToken: String,

	@field:SerializedName("full_name")
	val fullName: String,

	@field:SerializedName("user_id")
	val userId: String,

	@field:SerializedName("token_type")
	val tokenType: String,

	@field:SerializedName("expires_in")
	val expiresIn: Int,

	@field:SerializedName("email")
	val email: String
)
