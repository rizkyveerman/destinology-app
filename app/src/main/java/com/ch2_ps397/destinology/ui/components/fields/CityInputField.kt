package com.ch2_ps397.destinology.ui.components.fields

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun CityInputField(onSelect: () -> Unit) {
    var dropdownState by remember {
        mutableStateOf(false)
    }

    var city by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxWidth()
    ) {
        Card (
            border = BorderStroke(1.dp, LightGray)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .clickable {
                        dropdownState = !dropdownState
                    }
                    .padding(8.dp)
            ) {
                Text(
                    text = if (city == "") "Medan" else city,
                    color = Gray,
                    modifier = Modifier
                        .background(White)
                )
                Image(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
            }
        }
        if (dropdownState) {
            DropdownMenu(
                expanded = true,
                onDismissRequest = { dropdownState = false },
                modifier = Modifier
                    .widthIn(min = 300.dp)
                    .background(White)
            ) {

                val cities = listOf(
                    "Yogyakarta",
                    "Medan",
                    "Jakarta",
                    "Bandung",
                    "Surabaya",
                    "Lombok"
                )

                for (i in cities) {
                    DropdownMenuItem(
                        text = { Text(text = i) },
                        onClick = {
                            dropdownState = false
                            city = i
                            onSelect()
                        },
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCityInputField() {
    CityInputField {

    }
}