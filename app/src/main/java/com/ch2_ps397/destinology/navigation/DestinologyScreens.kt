package com.ch2_ps397.destinology.navigation

enum class DestinologyScreens {
    DestinologySplashScreen,
    DestionologyOnboardingScreen,
    DestinologyUserAuthScreen,
    DestinologyHomeScreen,
    DestinologyRecommendationScreen,
    DestinologyPlanScreen,
    DestinologyPlanDetailScreen,
    DestinologyScanLandmarkScreen,
    DestinologyCameraScreen,
    DestinologyCommunityScreen,
    DestinologyCommunityPostDetailScreen,
    DestinologyUserProfileScreen,
    DestinologySettingScreen;

    companion object {
        fun fromRoute(route: String) : DestinologyScreens =
            when( route.substringBefore("/")) {
                DestinologySplashScreen.name -> DestinologySplashScreen
                DestionologyOnboardingScreen.name -> DestionologyOnboardingScreen
                DestinologyUserAuthScreen.name -> DestinologyUserAuthScreen
                DestinologyHomeScreen.name -> DestinologyHomeScreen
                DestinologyRecommendationScreen.name -> DestinologyRecommendationScreen
                DestinologyPlanScreen.name -> DestinologyPlanScreen
                DestinologyPlanDetailScreen.name -> DestinologyPlanDetailScreen
                DestinologyScanLandmarkScreen.name -> DestinologyScanLandmarkScreen
                DestinologyCameraScreen.name -> DestinologyCameraScreen
                DestinologyCommunityScreen.name -> DestinologyCommunityScreen
                DestinologyCommunityPostDetailScreen.name -> DestinologyCommunityPostDetailScreen
                DestinologyUserProfileScreen.name -> DestinologyUserProfileScreen
                DestinologySettingScreen.name -> DestinologySettingScreen
                else -> throw IllegalArgumentException("$route not recognized.")
            }
    }
}