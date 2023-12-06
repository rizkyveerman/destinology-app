package com.ch2_ps397.destinology.ui.components.scaffold

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyTopBar(navigationIcon: @Composable () -> Unit, title: @Composable () -> Unit, menu: @Composable () -> Unit) {
    TopAppBar(
        title = title,
        navigationIcon = navigationIcon,
    )
}
