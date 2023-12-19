package com.ch2_ps397.destinology.core.model

data class MItinerary (
    val placeName: String,
    val price: Int,
    val rating: Float,
    val category: String,
    val day: Int
)

data class MGenerateItinerary (
    val city: String = "Yogyakarta",
    val n_days: Int = 1,
    val max_budget: Int = 150000
)