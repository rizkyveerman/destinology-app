package com.ch2_ps397.destinology.ui.components.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.components.button.DestinologyPrimaryButton
import com.ch2_ps397.destinology.ui.components.fields.DestinologyPasswordInput
import com.ch2_ps397.destinology.ui.components.fields.DestinologyTextInputFilled

@Composable
fun DestinoloyCreateAccountForm(
    onSubmit: (
        email: String,
        name: String,
        username: String,
        password: String,
    ) -> Unit
) {

    val nameState = rememberSaveable {
        mutableStateOf("")
    }

    val usernameState = rememberSaveable {
        mutableStateOf("")
    }

    val emailState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    Column {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                DestinologyTextInputFilled(
                    valueState = nameState,
                    labelId = "Your full name",
                    enabled = true,
                )
                Spacer(modifier = Modifier.height(16.dp))
                DestinologyTextInputFilled(
                    valueState = usernameState,
                    labelId = "Create username",
                    enabled = true,
                )
                Spacer(modifier = Modifier.height(16.dp))
                DestinologyTextInputFilled(
                    valueState = emailState,
                    labelId = "Email address",
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
                DestinologyPrimaryButton(enabled = true, text = "Buat akun") {
                    try {
                        onSubmit(
                            emailState.value,
                            nameState.value,
                            usernameState.value,
                            passwordState.value
                        )
                    } catch (e: Exception) {
                        throw e
                    }
                }
            }
        }
    }
}

@Composable
fun DestinologyLoginUserForm(
    onSubmit: (
        email: String,
        password: String,
    ) -> Unit
) {
    val emailState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordState = rememberSaveable {
        mutableStateOf("")
    }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }

    Column {
        Card {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                DestinologyTextInputFilled(
                    valueState = emailState,
                    labelId = "Email address",
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
                DestinologyPrimaryButton(enabled = true, text = "Login") {
                    try {
                        onSubmit(
                            emailState.value,
                            passwordState.value
                        )
                    } catch (e: Exception) {
                        throw e
                    }
                }
            }
        }
    }
}