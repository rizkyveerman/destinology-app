package com.ch2_ps397.destinology.ui.screen.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.scaffold.BottomBarNavigation
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologySearchBar

@Composable
fun DestinologyPlanScreen(navController: NavController) {
    Scaffold(
        topBar = {
            DestinologySearchBar(onSearch = {})
        },
        bottomBar = {
            BottomBarNavigation(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(DestinologyScreens.DestinologyGenerateItineraryScreen.name) }) {
                Row {
                    Image(imageVector = Icons.Default.Add, contentDescription = "New itinerary")
                    Text(text = "Plan Baru")
                }
            }
        }
    ) { paddingValues ->
        Text(text = "My Plan", modifier = Modifier.padding(paddingValues))
    }
}