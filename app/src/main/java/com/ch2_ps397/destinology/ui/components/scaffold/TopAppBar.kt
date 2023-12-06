package com.ch2_ps397.destinology.ui.components.scaffold

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyTopBar(navigationIcon: @Composable () -> Unit, title: @Composable () -> Unit, menu: @Composable () -> Unit) {
    TopAppBar(
        title = title,
        navigationIcon = navigationIcon,
    )
}
