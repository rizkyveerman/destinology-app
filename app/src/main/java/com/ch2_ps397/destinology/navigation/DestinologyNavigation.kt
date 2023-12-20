package com.ch2_ps397.destinology.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ch2_ps397.destinology.ui.screen.scan.DestinologyCameraScreen
import com.ch2_ps397.destinology.ui.screen.community.DestinologyCommunityPostDetailScreen
import com.ch2_ps397.destinology.ui.screen.community.DestinologyCommunityScreen
import com.ch2_ps397.destinology.ui.screen.discovery.DestinologyDiscoveryScreen
import com.ch2_ps397.destinology.ui.screen.discovery.DestinologyPlaceDetailsScreen
import com.ch2_ps397.destinology.ui.screen.onboarding.DestinologyOnboardingScreen
import com.ch2_ps397.destinology.ui.screen.plan.DestinologyPlanDetailScreen
import com.ch2_ps397.destinology.ui.screen.plan.DestinologyPlanScreen
import com.ch2_ps397.destinology.ui.screen.recommendation.DestinologyRecommendationScreen
import com.ch2_ps397.destinology.ui.screen.scan.DestinologyScanLandmarkScreen
import com.ch2_ps397.destinology.ui.screen.setting.DestinologySettingScreen
import com.ch2_ps397.destinology.ui.screen.splash.DestinologySplashScreen
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserCreateAccountScreen
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserLoginScreen
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserProfileScreen

@Composable
fun DestinologyNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinologyScreens.DestinologySplashScreen.name,
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
        composable(
            route = DestinologyScreens.DestinologyUserCreateAccountScreen.name,
        ) {
            DestinologyUserCreateAccountScreen(navController = navController)
        }
        composable(
            route = DestinologyScreens.DestinologyUserLoginScreen.name,
        ) {
            DestinologyUserLoginScreen(navController = navController)
        }
        composable(
            route = DestinologyScreens.DestinologyRecommendationScreen.name
        ) {
            DestinologyRecommendationScreen(navController = navController)
        }
        composable(
            route = DestinologyScreens.DestinologyPlanScreen.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            DestinologyPlanScreen(navController = navController)
        }
        composable(
            route = "${DestinologyScreens.DestinologyPlanDetailScreen.name}/{planId}",
            arguments = listOf(navArgument("planId") { type = NavType.StringType})
        ) { navBackStackEntry ->
            DestinologyPlanDetailScreen(navController = navController, navBackStackEntry = navBackStackEntry.arguments?.getString("planId"))
        }
        composable(
            route = DestinologyScreens.DestinologyDiscoveryScreen.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None }
        ) {
            DestinologyDiscoveryScreen(navController)
        }
        composable(
            "${DestinologyScreens.DestinologyPlaceDetailsScreen.name}/{placeId}",
            arguments = listOf(navArgument("placeId") { type = NavType.StringType})
        ) { navBackStackEntry ->
            DestinologyPlaceDetailsScreen(navController = navController, navBackStackEntry = navBackStackEntry.arguments?.getString("planId"))
        }
        composable(
            "${DestinologyScreens.DestinologyScanLandmarkScreen.name}/{nama}/{desc}/{fact}",
            arguments = listOf(
                navArgument("nama") { type = NavType.StringType },
                navArgument(name = "desc") { type = NavType.StringType },
                navArgument(name = "fact") { type = NavType.StringType }
            )
        ) { navBackStackEntry ->
            DestinologyScanLandmarkScreen(
                navController = navController,
                nama = navBackStackEntry.arguments?.getString("nama"),
                desc = navBackStackEntry.arguments?.getString("desc"),
                fact = navBackStackEntry.arguments?.getString("fact")
            )
        }
        composable(DestinologyScreens.DestinologyCameraScreen.name) {
            DestinologyCameraScreen(navController)
        }
        composable(DestinologyScreens.DestinologyCommunityScreen.name) {
            DestinologyCommunityScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologyCommunityPostDetailScreen.name) {
            DestinologyCommunityPostDetailScreen(navController = navController)
        }
        composable(
            route = DestinologyScreens.DestinologyUserProfileScreen.name,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
        ) {
            DestinologyUserProfileScreen(navController = navController)
        }
        composable(DestinologyScreens.DestinologySettingScreen.name) {
            DestinologySettingScreen(navController = navController)
        }
    }
}