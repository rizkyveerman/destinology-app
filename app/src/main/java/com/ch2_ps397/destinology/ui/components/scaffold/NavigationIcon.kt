package com.ch2_ps397.destinology.ui.components.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DestinologyAppBarNavigationIcon(onNavigateUp: () -> Unit) {
    Image(
        imageVector = Icons.TwoTone.ArrowBack,
        contentDescription = "Navigate up",
        modifier = Modifier
            .clickable {
                onNavigateUp()
            }
            .padding(16.dp)
    )
}