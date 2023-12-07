package com.ch2_ps397.destinology.ui.screen.generate

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.button.Button
import com.ch2_ps397.destinology.ui.components.form.DestinationInputForm
import com.ch2_ps397.destinology.ui.components.imagery.ImageBackground
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyGenerateItineraryScreen(navController: NavController) {
    ImageBackground()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Choose your preferred\ndestination and style to\nget started",
                color = White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            DestinationInputForm()
            Spacer(modifier = Modifier.height(16.dp))
            Button(enabled = true, text = "Generate") {
                //TODO hit API & go to the recommendation screen  once success generate new itenary

                navController.navigate(DestinologyScreens.DestinologyRecommendationScreen.name)
            }
        }
    }
}