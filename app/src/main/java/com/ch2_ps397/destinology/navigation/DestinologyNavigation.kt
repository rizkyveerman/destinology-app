package com.ch2_ps397.destinology.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ch2_ps397.destinology.ui.screen.community.DestinologyCommunityPostDetailScreen
import com.ch2_ps397.destinology.ui.screen.community.DestinologyCommunityScreen
import com.ch2_ps397.destinology.ui.screen.home.DestinologyHomeScreen
import com.ch2_ps397.destinology.ui.screen.onboarding.DestinologyOnboardingScreen
import com.ch2_ps397.destinology.ui.screen.plan.DestinologyPlanDetailScreen
import com.ch2_ps397.destinology.ui.screen.plan.DestinologyPlanScreen
import com.ch2_ps397.destinology.ui.screen.plan.DestinologyTripDetailScreen
import com.ch2_ps397.destinology.ui.screen.recommendation.DestinologyRecommendationScreen
import com.ch2_ps397.destinology.ui.screen.setting.DestinologySettingScreen
import com.ch2_ps397.destinology.ui.screen.splash.DestinologySplashScreen
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserAuthScreen
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserProfileScreen

@Composable
fun DestinologyNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinologyScreens.DestinologySplashScreen.name,
        enterTransition = { EnterTransition.None},
        exitTransition = { ExitTransition.None},
        popEnterTransition = { EnterTransition.None},
        popExitTransition = { ExitTransition.None}
    ) {
        composable(DestinologyScreens.DestinologySplashScreen.name) {
            DestinologySplashScreen(navController = navController)
        }
        composable(DestinologyScreens.DestionologyOnboardingScreen.name) {
            DestinologyOnboardingScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyUserAuthScreen.name) {
            DestinologyUserAuthScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyHomeScreen.name) {
            DestinologyHomeScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyRecommendationScreen.name) {
            DestinologyRecommendationScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyPlanScreen.name) {
            DestinologyPlanScreen(navController = navController)
        }
        composable(
            "${DestinologyScreens.DestinologyPlanDetailScreen.name}/{planId}",
            arguments = listOf(navArgument("planId") { type = NavType.StringType})
        ) { navBackStackEntry ->
            DestinologyPlanDetailScreen(navController = navController, navBackStackEntry = navBackStackEntry.arguments?.getString("planId"))
        }
        composable("${ DestinologyScreens.DestinologyTripDetailScreen.name }/tripId", arguments = listOf(
            navArgument("tripId") { type = NavType.StringType})) { navBackStackEntry ->
            DestinologyTripDetailScreen(navController = navController, navBackStackEntry = navBackStackEntry.arguments?.getString("tripId"))
        }
        composable(DestinologyScreens.DestinologyCommunityScreen.name) {
            DestinologyCommunityScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyCommunityPostDetailScreen.name) {
            DestinologyCommunityPostDetailScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyUserProfileScreen.name) {
            DestinologyUserProfileScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologySettingScreen.name) {
            DestinologySettingScreen(navController = navController)
        }
    }
}