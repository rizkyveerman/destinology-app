package com.ch2_ps397.destinology.ui.screen.discovery

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ch2_ps397.destinology.ui.components.imagery.ImageBackground

@Composable
fun DestinologyPlaceDetailsScreen(navController: NavController, navBackStackEntry: String?) {
    Surface {
        ImageBackground("https://images.unsplash.com/photo-1682685797439-a05dd915cee9?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
        Box(modifier = Modifier) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {

            }
        }
    }
}