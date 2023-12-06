package com.ch2_ps397.destinology.ui.screen.recommendation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ch2_ps397.destinology.ui.components.cards.ItineraryDayCard

@Composable
fun DestinologyRecommendationScreen(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        ItineraryDayCard(isActive = true, "Day 1", "12 Desember") {}
        ItineraryDayCard(isActive = false, "Day 2", "13 Desember") {}
        ItineraryDayCard(isActive = false, "Day 3", "14 Desember") {}
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Plan Day 1")
    }
}

@Preview
@Composable
fun PreviewRecommendationScreen() {
    DestinologyRecommendationScreen(navController = rememberNavController())
}