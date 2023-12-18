package com.ch2_ps397.destinology.ui.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun DestinologySplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Destinology",
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        LaunchedEffect(key1 = true) {
            delay(2000L)

            navController.navigate(DestinologyScreens.DestionologyOnboardingScreen.name) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }

        }
    }
}