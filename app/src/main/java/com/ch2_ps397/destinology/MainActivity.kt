package com.ch2_ps397.destinology

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ch2_ps397.destinology.navigation.DestinologyNavigation
import com.ch2_ps397.destinology.ui.theme.DestinologyTheme
import com.ch2_ps397.destinology.ui.theme.VeryLightGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DestinologyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = VeryLightGray
                ) {
                    DestinologyNavigation()
                }
            }
        }
    }
}