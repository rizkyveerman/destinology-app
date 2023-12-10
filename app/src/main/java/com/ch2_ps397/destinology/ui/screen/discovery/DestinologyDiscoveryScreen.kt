package com.ch2_ps397.destinology.ui.screen.discovery

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.ui.components.scaffold.BottomBarNavigation
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologySearchBar
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyDiscoveryScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.background(White).padding(16.dp)
            ) {
                Text(text = "Temukan", fontSize = 24.sp)
                Text(text = "Destinasimu", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                DestinologySearchBar(onSearch = {})
            }
        },
        bottomBar = {
            BottomBarNavigation(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().background(VeryLightGray).padding(innerPadding)
        ) {
            Column {
                Text(text = "Tempat popular", fontWeight = FontWeight.Bold)
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    for (i in 1..5) {
                        item {
                            Text(text = "Place $i", modifier = Modifier.width(200.dp))
                        }
                    }
                }
            }
        }
    }
}
