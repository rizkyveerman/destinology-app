package com.ch2_ps397.destinology.ui.screen.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.ui.components.scaffold.BottomBarNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyUserProfileScreen(navController: NavController) {
    val username = "rizky"

    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
            ) {
                Text(
                    text = "Your profile",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        },
        bottomBar = {
            BottomBarNavigation(navController = navController)
        }
    ) {

    }
}