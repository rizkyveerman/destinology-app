package com.ch2_ps397.destinology.ui.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.button.Button
import com.ch2_ps397.destinology.ui.components.imagery.ImageBackground

@Composable
fun DestinologyOnboardingScreen(navController: NavController) {
   ImageBackground()
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 16.dp, 16.dp, 64.dp)
    ) {
        DestinologyOnboardingContent(navController = navController)
    }
}

@Composable
fun DestinologyOnboardingContent(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Unveil Hidden Wonders",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 48.sp,
            lineHeight = 48.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(enabled = true, text = "Get Started") {
            navController.navigate(DestinologyScreens.DestinologyRecommendationScreen.name) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDestinologyOnboardingScreen() {
    DestinologyOnboardingScreen(navController = rememberNavController())
}

@Preview
@Composable
fun PreviewDestinologyOnboardingContent() {
    DestinologyOnboardingContent(navController = rememberNavController())
}