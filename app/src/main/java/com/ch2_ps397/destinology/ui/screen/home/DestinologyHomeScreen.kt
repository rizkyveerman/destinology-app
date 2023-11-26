package com.ch2_ps397.destinology.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun DestinologyHomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://switzerland-tour.com/storage/media/4-ForArticles/swiss-mountains.jpg",
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
    }
}