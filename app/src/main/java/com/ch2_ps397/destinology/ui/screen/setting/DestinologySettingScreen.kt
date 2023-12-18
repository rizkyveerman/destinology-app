package com.ch2_ps397.destinology.ui.screen.setting

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ch2_ps397.destinology.ui.components.button.DestinologyPrimaryButton

@Composable
fun DestinologySettingScreen(navController: NavController) {
    DestinologyPrimaryButton(enabled = true, text = "Logout") {
        //TODO logout Button
    }
}