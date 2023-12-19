package com.ch2_ps397.destinology.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DestinologyCreateUserResponse(

	@field:SerializedName("full_name")
	val fullName: String,

	@field:SerializedName("created_at")
	val createdAt: Long,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)
