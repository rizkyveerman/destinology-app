package com.ch2_ps397.destinology.navigation

enum class DestinologyScreens {
    DestinologySplashScreen,
    DestionologyOnboardingScreen,
    DestinologyUserAuthScreen,
    DestinologyRecommendationScreen,
    DestinologyPlanScreen,
    DestinologyPlanDetailScreen,
    DestinologyScanLandmarkScreen,
    DestinologyCameraScreen,
    DestinologyDiscoveryScreen,
    DestinologyPlaceDetailsScreen,
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
                DestinologyRecommendationScreen.name -> DestinologyRecommendationScreen
                DestinologyPlanScreen.name -> DestinologyPlanScreen
                DestinologyPlanDetailScreen.name -> DestinologyPlanDetailScreen
                DestinologyScanLandmarkScreen.name -> DestinologyScanLandmarkScreen
                DestinologyCameraScreen.name -> DestinologyCameraScreen
                DestinologyCommunityScreen.name -> DestinologyCommunityScreen
                DestinologyCommunityPostDetailScreen.name -> DestinologyCommunityPostDetailScreen
                DestinologyDiscoveryScreen.name -> DestinologyDiscoveryScreen
                DestinologyPlaceDetailsScreen.name -> DestinologyPlaceDetailsScreen
                DestinologyUserProfileScreen.name -> DestinologyUserProfileScreen
                DestinologySettingScreen.name -> DestinologySettingScreen
                else -> throw IllegalArgumentException("$route not recognized.")
            }
    }
}