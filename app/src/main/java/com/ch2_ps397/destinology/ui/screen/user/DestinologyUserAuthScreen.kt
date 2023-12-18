package com.ch2_ps397.destinology.ui.screen.user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.di.Injection
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.form.DestinologyLoginUserForm

@Composable
fun DestinologyUserAuthScreen(navController: NavController,
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
        DestinologyLoginUserForm(navController)
    }
}
