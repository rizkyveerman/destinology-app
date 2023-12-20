package com.ch2_ps397.destinology.ui.components.fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun NumberInput(onChanged: (number: Int) -> Unit) {
    var number by remember {
        mutableIntStateOf(3)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(White)
    ) {
        Card(
            border = BorderStroke(1.dp, LightGray),
            modifier = Modifier
                .width(72.dp)
                .height(48.dp)
                .background(White)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .background(White)
                .clickable {
                    if (number > 1 ) {
                        number--
                        onChanged(number)
                    }
                }
            ) {
                Text(text = "-")
            }
        }
        Card(
            border = BorderStroke(1.dp, LightGray),
            modifier = Modifier
                .width(180.dp)
                .height(48.dp)
                .background(White)
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .background(White)) {
                Text(text = number.toString())
            }
        }
        Card(
            border = BorderStroke(1.dp, LightGray),
            modifier = Modifier
                .width(72.dp)
                .height(48.dp)
                .background(White)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
                    .clickable {
                        if (number < 3 ) {
                            number++
                            onChanged(number)
                        }
                        onChanged(number)
                    }
            ) {
                Text(text = "+")
            }
        }
    }
}

@Preview
@Composable
fun PreviewNumberInput() {
    NumberInput {

    }
}