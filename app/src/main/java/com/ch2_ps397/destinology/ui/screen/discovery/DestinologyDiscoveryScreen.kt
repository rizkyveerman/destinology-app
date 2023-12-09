package com.ch2_ps397.destinology.ui.screen.discovery

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ch2_ps397.destinology.ui.components.scaffold.BottomBarNavigation
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologySearchBar

@Composable
fun DestinologyDiscoveryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            DestinologySearchBar(onSearch = {})
        },
        bottomBar = {
            BottomBarNavigation(navController = navController)
        }
    ) { innerPadding ->

    }
}