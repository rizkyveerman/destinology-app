package com.ch2_ps397.destinology.ui.components.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.button.DestinologyPrimaryButton
import com.ch2_ps397.destinology.ui.components.button.DestinologyTransparentButton
import com.ch2_ps397.destinology.ui.components.fields.DestinologyPasswordInput
import com.ch2_ps397.destinology.ui.components.fields.DestinologyTextInputFilled
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyLoginUserForm(navController: NavController) {
    var isCreateAccount by remember {
        mutableStateOf(false)
    }

    val nameState = rememberSaveable {
        mutableStateOf("")
    }

    val emailState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable { mutableStateOf(false)}

    Column {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .background(White)
                    .padding(16.dp)
            )  {
                if (isCreateAccount) {
                    DestinologyTextInputFilled(
                        valueState = nameState,
                        labelId = "Your name",
                        enabled = true,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                DestinologyTextInputFilled(
                    valueState = emailState,
                    labelId = "Email",
                    enabled = true,
                )
                Spacer(modifier = Modifier.height(16.dp))
                DestinologyPasswordInput(
                    modifier = Modifier,
                    passwordState = passwordState,
                    enabled = true,
                    passwordVisibility = passwordVisibility
                )
                Spacer(modifier = Modifier.height(16.dp))
                DestinologyPrimaryButton(enabled = true, text = if (isCreateAccount) "Buat akun" else "Login") {
                    if (isCreateAccount) {
                        //TODO do API call to create account
                        navController.navigate(DestinologyScreens.DestinologyPlanScreen.name) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    } else {
                        //TODO do API call to login
                        navController.navigate(DestinologyScreens.DestinologyPlanScreen.name) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        DestinologyTransparentButton(enabled = true, text = if (isCreateAccount) "Sudah punya akun? Masuk aja" else "Belum punya akun? Buat dulu sekarang") {
            isCreateAccount = !isCreateAccount
        }
    }
}

@Preview
@Composable
fun PreviewUserForm() {
    DestinologyLoginUserForm(navController = rememberNavController())
}