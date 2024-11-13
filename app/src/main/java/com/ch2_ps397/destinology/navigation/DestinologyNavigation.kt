package com.ch2_ps397.destinology.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.ch2_ps397.destinology.ui.screen.onboarding.DestinologyOnboardingScreen
import com.ch2_ps397.destinology.ui.screen.user.DestinologyUserAuthActivity

@Composable
fun DestinologyNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.AuthGraph,
    ) {
        authGraph(navController)
    }
}

fun NavGraphBuilder.authGraph(navController: NavController) {
    navigation<Route.AuthGraph>(startDestination = Route.Onboarding) {
        composable<Route.Onboarding> {
            DestinologyOnboardingScreen(onNavigateToAuth = {
                navController.navigate(route = Route.UserAuth)
            })
        }

        composable<Route.UserAuth> {
            DestinologyUserAuthActivity(onNavigateToHome = {
                navController.navigate(Route.Home)
            })
        }
    }
}