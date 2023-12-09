package com.ch2_ps397.destinology.navigation

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class DestinologyBottomNavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: DestinologyScreens
)