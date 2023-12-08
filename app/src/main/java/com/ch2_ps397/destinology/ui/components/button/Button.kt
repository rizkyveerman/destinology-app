package com.ch2_ps397.destinology.ui.components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun Button(enabled: Boolean, text: String, onClick: () -> Unit) {
    Button(
        enabled = enabled,
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(Orange),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            disabledElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,
            pressedElevation = 0.dp
        ),
        contentPadding = PaddingValues(
            vertical = 16.dp,
            horizontal = 24.dp
        ),

    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = White
        )
    }
}

@Composable
fun DestinologyFloatingButton(
    content: @Composable () -> Unit,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = Modifier
            .widthIn(min = 48.dp)
            .height(48.dp)
        ,
        containerColor = Orange,
        contentColor = White,
        content = content
    )
}

@Composable
fun SmallButton(text: String, onClick: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = LightGray,
            contentColor = Black
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun PreviewButton() {
    SmallButton("Text") {

    }
}