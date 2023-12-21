package com.ch2_ps397.destinology.ui.screen.user

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.di.Injection
import com.ch2_ps397.destinology.core.utils.Resource
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.button.DestinologyTransparentButton
import com.ch2_ps397.destinology.ui.components.cards.DestinologyCardDialog
import com.ch2_ps397.destinology.ui.components.form.DestinologyLoginUserForm

@Composable
fun DestinologyUserLoginScreen(navController: NavController,
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

    userAuthViewModel.resource.collectAsState(initial = Resource.Idle).value.let { resource ->
        if (showDialog) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .customDialogModifier(CustomDialogPosition.TOP)
            ){
                DestinologyCardDialog(showDialog = showDialog) { showDialog = false }
            }
        }

        when(resource) {
            is Resource.Loading -> {
                showDialog = true
            }
            is Resource.Success -> {
                Toast.makeText(LocalContext.current, resource.data.toString(), Toast.LENGTH_LONG).show()
                showDialog = false
            }
            is Resource.Error -> {
                showDialog = false
                Toast.makeText(LocalContext.current, resource.message, Toast.LENGTH_LONG).show()
            }
            else -> {
                showDialog = false
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
            DestinologyLoginUserForm { email, password ->
                userAuthViewModel.loginUser(email = email, password = password, navController = navController)
            }
            Spacer(modifier = Modifier.height(16.dp))
            DestinologyTransparentButton(enabled = true, text = "Belum punya akun? Buat dulu sekarang") {
                navController.navigate(DestinologyScreens.DestinologyUserCreateAccountScreen.name) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            }
        }
    }
}