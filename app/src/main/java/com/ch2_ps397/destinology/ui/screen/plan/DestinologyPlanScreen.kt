package com.ch2_ps397.destinology.ui.screen.plan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.ch2_ps397.destinology.ui.components.scaffold.BottomBarNavigation
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.Orange
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
            BottomBarNavigation(navController = navController)
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
        modifier = Modifier.background(LightGray)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            item {
                Text(
                    text = "Plan 1",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("${DestinologyScreens.DestinologyPlanDetailScreen.name}/1")
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}