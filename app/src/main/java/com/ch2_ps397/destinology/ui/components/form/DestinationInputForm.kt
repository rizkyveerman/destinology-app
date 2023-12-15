package com.ch2_ps397.destinology.ui.components.form

import android.icu.text.NumberFormat
import android.icu.util.Currency
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ch2_ps397.destinology.ui.components.fields.Dropdown
import com.ch2_ps397.destinology.ui.components.fields.NumberInput
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.OrangeLight
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinationInputForm(
    onCityChanged: (city: String) -> Unit,
    onDurationChanged: (duration: Int) -> Unit,
    onPriceChanged: (price: String) -> Unit
) {
    val cities = listOf(
        "Yogyakarta",
        "Medan",
        "Jakarta",
        "Bandung",
        "Surabaya",
        "Lombok"
    )

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
                color = Black,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Dropdown(listOfItem = cities) {
                
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
                color = Black,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            NumberInput { number ->
                onDurationChanged(number)
            }
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 0.dp, 16.dp, 16.dp)) {
            Text(
                text = "Budget range",
                fontWeight = FontWeight.Bold,
                color = Black,
                modifier = Modifier
                    .background(White)
            )
            Spacer(modifier = Modifier.height(12.dp))
            PriceRangeSlider()
        }
    }
}

@Composable
fun PriceRangeSlider() {
    var sliderPosition by remember { mutableFloatStateOf(1f) }
    val budgetRangeInRupiah = sliderPosition.times(1000000)

    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.maximumFractionDigits = 0
    numberFormat.currency = Currency.getInstance("IDR")

    Column {
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = Orange,
                    activeTrackColor = Orange,
                    inactiveTrackColor = OrangeLight,
                ),
                valueRange = 0f..5f
            )
        }
        Text(
            text = numberFormat.format(budgetRangeInRupiah),
            color = Black,
        )
    }
}


@Composable
fun RatingSlider() {
    var sliderPosition by remember { mutableFloatStateOf(4f) }

    Column {
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = Orange,
                    activeTrackColor = Orange,
                    inactiveTrackColor = OrangeLight,
                ),
                valueRange = 0f..5f,
                steps = 5
            )
        }
        Text(
            text = "$sliderPosition bintang",
            fontWeight = FontWeight.Bold,
            color = Black,
        )
    }
}
