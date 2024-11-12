package com.ch2_ps397.destinology.ui.components.fields

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dropdown(listOfItem: List<Any>, onSelect: (selectedCity: String) -> Unit) {
    var dropdownState by remember {
        mutableStateOf(false)
    }

    var item by remember {
        mutableStateOf("")
    }

    Card(
        modifier = Modifier
            .height(48.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    dropdownState = !dropdownState
                }
                .padding(8.dp)
        ) {
            Text(
                text = if (item == "") listOfItem[0].toString() else item,
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
        ) {
            for (i in listOfItem) {
                DropdownMenuItem(
                    text = { Text(text = i.toString()) },
                    onClick = {
                        dropdownState = false
                        item = i.toString()
                        onSelect(i.toString())
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDropdown() {
    Dropdown(
        listOfItem = listOf(
            "Item1",
            "Item2"
        )
    ) {

    }
}