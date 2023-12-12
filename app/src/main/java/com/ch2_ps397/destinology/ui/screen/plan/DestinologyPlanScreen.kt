package com.ch2_ps397.destinology.ui.screen.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.cards.DestinologyItineraryCard
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologyBottomBarNavigation
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyPlanScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { 
                Text(text = "My Itinerary")
            })
        },
        bottomBar = {
            DestinologyBottomBarNavigation(navController = navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(DestinologyScreens.DestinologyGenerateItineraryScreen.name) },
                containerColor = Orange,
                contentColor = White,
            ) {
                Image(
                    imageVector = Icons.Default.Add,
                    contentDescription = "New itinerary",
                    colorFilter = ColorFilter.tint(
                        White
                    )
                )
            }
        },
        modifier = Modifier.background(VeryLightGray)
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            LazyColumn(
                contentPadding = PaddingValues(top = 16.dp),
                modifier = Modifier
                    .background(VeryLightGray)
                    .padding(horizontal = 16.dp)
            ) {
                for (i in 1..7) {
                    item {
                        Box(modifier = Modifier.padding(bottom = 16.dp)) {
                            DestinologyItineraryCard(
                                imageModel = "https://images.unsplash.com/photo-1556375413-f6cdc5e17398?q=80&w=2082&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                title = "Itinerary 1",
                                rating = 4.6f
                            ) {

                            }
                        }
                    }
                }
            }

        }
    }
}