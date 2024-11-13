package com.ch2_ps397.destinology.ui.screen.user

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ch2_ps397.destinology.ui.theme.DestinologyTheme

class DestinologyUserAuthActivity(private val onNavigateToHome: () -> Unit) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setContent {
            DestinologyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val isLogin by rememberSaveable { mutableStateOf(false) }

                    if (isLogin) {
                        DestinologyUserLoginScreen(
                            onSwitchToRegister = TODO(),
                            onSubmit = TODO()
                        )
                    } else {
                        DestinologyUserCreateAccountScreen(
                            onSwitchToRegister = TODO(),
                            onSubmit = TODO()
                        )
                    }
                }
            }
        }
    }
}