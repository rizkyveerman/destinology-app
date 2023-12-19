package com.ch2_ps397.destinology.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenerateItineraryResponse(
	@field:SerializedName("itinerary")
	val itinerary: List<ItineraryItem>
)

data class ItineraryItem(

	@field:SerializedName("place_name")
	val placeName: String,

	@field:SerializedName("price")
	val price: Int,

	@field:SerializedName("rating")
	val rating: Float,

	@field:SerializedName("category")
	val category: String,

	@field:SerializedName("day")
	val day: Int
)
