package com.ch2_ps397.destinology.ui.components.fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun Dropdown(listOfItem: List<Any>, onSelect: () -> Unit) {
    var dropdownState by remember {
        mutableStateOf(false)
    }

    var item by remember {
        mutableStateOf("")
    }

    Card (
        border = BorderStroke(1.dp, LightGray),
        modifier = Modifier
            .height(48.dp)
            .background(White)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .clickable {
                    dropdownState = !dropdownState
                }
                .padding(8.dp)
        ) {
            Text(
                text = if (item == "") listOfItem[0].toString() else item,
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
            for (i in listOfItem) {
                DropdownMenuItem(
                    text = { Text(text = i.toString()) },
                    onClick = {
                        dropdownState = false
                        item = i.toString()
                        onSelect()
                    },
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDropdown() {
    Dropdown(listOfItem = listOf(
        "Item1",
        "Item2"
    )) {

    }
}