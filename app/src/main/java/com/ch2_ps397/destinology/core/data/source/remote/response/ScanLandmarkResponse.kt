package com.ch2_ps397.destinology.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ScanLandmarkResponse(

	@field:SerializedName("fact")
	val fact: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("desc")
	val desc: String
)
