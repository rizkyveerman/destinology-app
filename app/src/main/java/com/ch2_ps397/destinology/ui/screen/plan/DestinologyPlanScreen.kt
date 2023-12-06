package com.ch2_ps397.destinology.ui.screen.plan

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
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
        }
    ) { paddingValues ->
        Text(text = "My Plan")
    }
}