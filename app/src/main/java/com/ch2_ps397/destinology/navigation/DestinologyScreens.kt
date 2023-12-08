package com.ch2_ps397.destinology.navigation

enum class DestinologyScreens {
    DestinologySplashScreen,
    DestionologyOnboardingScreen,
    DestinologyUserAuthScreen,
    DestinologyGenerateItineraryScreen,
    DestinologyRecommendationScreen,
    DestinologyPlanScreen,
    DestinologyPlanDetailScreen,
    DestinologyScanLandmarkScreen,
    ScanActivity,
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
                DestinologyGenerateItineraryScreen.name -> DestinologyGenerateItineraryScreen
                DestinologyRecommendationScreen.name -> DestinologyRecommendationScreen
                DestinologyPlanScreen.name -> DestinologyPlanScreen
                DestinologyPlanDetailScreen.name -> DestinologyPlanDetailScreen
                DestinologyScanLandmarkScreen.name -> DestinologyScanLandmarkScreen
                ScanActivity.name -> ScanActivity
                DestinologyCameraScreen.name -> DestinologyCameraScreen
                DestinologyCommunityScreen.name -> DestinologyCommunityScreen
                DestinologyCommunityPostDetailScreen.name -> DestinologyCommunityPostDetailScreen
                DestinologyUserProfileScreen.name -> DestinologyUserProfileScreen
                DestinologySettingScreen.name -> DestinologySettingScreen
                else -> throw IllegalArgumentException("$route not recognized.")
            }
    }
}