package com.ch2_ps397.destinology.ui.screen.user

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.di.Injection
import com.ch2_ps397.destinology.core.utils.Resource
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.button.DestinologyTransparentButton
import com.ch2_ps397.destinology.ui.components.form.DestinoloyCreateAccountForm
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyUserCreateAccountScreen(navController: NavController,
                              userAuthViewModel: DestinologyUserAuthViewModel = viewModel(
                               factory = ViewModelFactory(
                                   Injection.provideItineraryRepository(
                                       LocalContext.current
                                   ),
                                   Injection.provideLandmarkRepository(
                                       LocalContext.current
                                   ),
                                   Injection.provideUserRepository(
                                       LocalContext.current
                                   )
                               )
                           )
) {
    var showDialog by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }

    userAuthViewModel.resource.collectAsState(initial = Resource.Idle).value.let {  resource ->
        when(resource) {
            is Resource.Loading -> {
                showDialog = true
            }
            is Resource.Success -> {
                isSuccess = true
                navController.navigate(DestinologyScreens.DestinologyUserLoginScreen.name) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            }
            is Resource.Error -> {
                isSuccess = false
            }
            else -> {

            }
        }
    }

    if (showDialog) {
        Dialog(onDismissRequest = {showDialog = false}) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Transparent)
            ) {
                Card {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .widthIn(min = 100.dp)
                            .heightIn(min = 100.dp)
                            .padding(16.dp)
                            .background(White)
                    ) {
                        Text(text = "Loading...")
                    }
                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Daftarkan akun kamu untuk\nmelanjutkan perjalanan.",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(16.dp))
        DestinoloyCreateAccountForm { email, fullName, username, password ->
            userAuthViewModel.registerUser(email = email, fullname = fullName, username = username, password = password)
        }
        Spacer(modifier = Modifier.height(16.dp))
        DestinologyTransparentButton(enabled = true, text = "Sudah punya akun? Masuk aja") {
            navController.navigate(DestinologyScreens.DestinologyUserLoginScreen.name) {
                popUpTo(navController.graph.id) {
                    inclusive = true
                }
            }
        }
    }
}