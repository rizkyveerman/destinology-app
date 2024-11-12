package com.ch2_ps397.destinology.ui.components.cards

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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

enum class CustomDialogPosition {
    BOTTOM, TOP
}

fun Modifier.customDialogModifier(pos: CustomDialogPosition) = layout { measurable, constraints ->

    val placeable = measurable.measure(constraints);
    layout(constraints.maxWidth, constraints.maxHeight) {
        when (pos) {
            CustomDialogPosition.BOTTOM -> {
                placeable.place(0, constraints.maxHeight - placeable.height, 10f)
            }

            CustomDialogPosition.TOP -> {
                placeable.place(0, 0, 10f)
            }
        }
    }
}

@Composable
fun DestinologyCardDialog(showDialog: Boolean, onDismissRequest: (showDialog: Boolean) -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest(showDialog) }) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Card(
                elevation = CardDefaults.cardElevation(2.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .widthIn(min = 100.dp)
                        .heightIn(min = 100.dp)
                        .padding(16.dp)
                ) {
                    CircularProgressIndicator(
                        strokeCap = StrokeCap.Round
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Loading...")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDestinologyCardDialog() {
    DestinologyCardDialog(true) {}
}