package com.ch2_ps397.destinology.navigation

import kotlinx.serialization.Serializable

class Route {

    @Serializable
    object AuthGraph

    @Serializable
    object TripPlanGraph

    @Serializable
    object Onboarding


    @Serializable
    object UserAuth

    @Serializable
    object Home

    @Serializable
    object Recommendation

    @Serializable
    object Scanner

    @Serializable
    object ScannerResult

    @Serializable
    data class Profile(val id: String)
}