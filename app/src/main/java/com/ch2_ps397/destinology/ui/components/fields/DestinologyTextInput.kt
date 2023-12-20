package com.ch2_ps397.destinology.ui.components.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.Indigo
import com.ch2_ps397.destinology.ui.theme.IndigoLight
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyTextInput(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = false,
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onActions,
        enabled = enabled,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = White,
            cursorColor = Indigo,
            disabledContainerColor = VeryLightGray,
            errorContainerColor = Color.Red,
            unfocusedContainerColor = VeryLightGray,
            ),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp)
    )
}

@Composable
fun PasswordVisibility(passwordVisibility: MutableState<Boolean>) {
    val isVisible = passwordVisibility.value
    IconButton(onClick = { passwordVisibility.value !=isVisible }) {
        Icons.Default.Close
    }
}

@Composable
fun DestinologyPasswordInput(
    modifier: Modifier,
    passwordState: MutableState<String>,
    enabled: Boolean,
    labelId: String = "Password",
    passwordVisibility: MutableState<Boolean>,
    imeAction: ImeAction = ImeAction.Done,
    onAction: KeyboardActions = KeyboardActions.Default
) {
    val visualTransformation = if(passwordVisibility.value) VisualTransformation.None
    else PasswordVisualTransformation()

    TextField(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = labelId)},
        modifier = modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction),
        visualTransformation =  visualTransformation,
        trailingIcon = { PasswordVisibility(passwordVisibility) },
        keyboardActions = onAction,
        enabled = enabled,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Indigo,
            focusedContainerColor = White,
            cursorColor = Indigo,
            disabledContainerColor = White,
            unfocusedContainerColor = White,
            selectionColors = TextSelectionColors(
                backgroundColor = IndigoLight,
                handleColor = Indigo
            ),
            unfocusedIndicatorColor = Gray,
            focusedIndicatorColor = Indigo
        ),
    )
}


@Composable
fun DestinologyTextInputFilled(
    modifier: Modifier = Modifier,
    valueState: MutableState<String>,
    labelId: String,
    enabled: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default,
    onActions: KeyboardActions = KeyboardActions.Default,
) {
    TextField(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        value = valueState.value,
        onValueChange = { valueState.value = it },
        label = { Text(text = labelId) },
        singleLine = false,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onActions,
        enabled = enabled,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Indigo,
            focusedContainerColor = White,
            cursorColor = Indigo,
            disabledContainerColor = White,
            unfocusedContainerColor = White,
            selectionColors = TextSelectionColors(
                backgroundColor = IndigoLight,
                handleColor = Indigo
            ),
            unfocusedIndicatorColor = Gray,
            focusedIndicatorColor = Indigo

        ),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 8.dp)
    )
}