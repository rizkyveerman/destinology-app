package com.ch2_ps397.destinology.ui.components.form

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.components.fields.CityInputField
import com.ch2_ps397.destinology.ui.components.fields.DestinationModeInputField
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.OrangeLight
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinationInputForm() {

    var selectedCity by remember {
        mutableStateOf("")
    }

    var selectedMode by remember {
        mutableStateOf("")
    }

    Card(
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        colors = CardDefaults.cardColors(White),
    ) {
        Column(
            modifier = Modifier
                .background(White)
                .padding(16.dp)
        ) {
            Text(
                text = "City",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            CityInputField {
                selectedCity = ""
            }
        }

        Column(
            modifier = Modifier
                .background(White)
                .padding(16.dp)
        ) {
            Text(
                text = "Duration (days)",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
           Box(
               contentAlignment = Alignment.Center,
               modifier = Modifier
                   .background(OrangeLight)
                   .padding(16.dp)
                   .clip(CircleShape)
           ) {
               Image(imageVector = Icons.Default.Add, contentDescription = "Add trip duration")
           }
        }

        Column(
            modifier = Modifier
                .background(White)
                .padding(16.dp)
        ) {
            Text(
                text = "Mode",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            DestinationModeInputField {
                selectedMode = ""
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp)) {
            Text(
                text = "Budget range",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            PriceRangeSlider()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PriceRangeSlider() {
    var sliderPosition by remember { mutableStateOf(2f..4f) }

    Column {
        RangeSlider(
            colors = SliderDefaults.colors(
                thumbColor = Orange,
                activeTrackColor = Orange,
                activeTickColor = OrangeLight,
                inactiveTrackColor = OrangeLight,
                inactiveTickColor = OrangeLight,
                disabledThumbColor = Orange,
                disabledActiveTrackColor = Orange,
                disabledActiveTickColor = Orange,
                disabledInactiveTrackColor = Orange,
                disabledInactiveTickColor = Orange
            ),
            value = sliderPosition,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 1f..5f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
        Text(text = "Rp. ${sliderPosition}")
    }
}


@Preview
@Composable
fun PreviewDestinationInputForm() {
    DestinationInputForm()
}