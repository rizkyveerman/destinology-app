package com.ch2_ps397.destinology.ui.components.form

import android.icu.text.NumberFormat
import android.icu.util.Currency
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ch2_ps397.destinology.ui.components.fields.Dropdown
import com.ch2_ps397.destinology.ui.components.fields.NumberInput

@Composable
fun DestinationInputForm(
    onCityChanged: (city: String) -> Unit,
    onDurationChanged: (duration: Int) -> Unit,
    onPriceChanged: (price: Int) -> Unit
) {
    val cities = listOf(
        "Yogyakarta",
        "Jakarta",
        "Surabaya",
    )

    Card(
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "City",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(12.dp))
            Dropdown(listOfItem = cities) {
                onCityChanged(it)
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Duration (days)",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(12.dp))
            NumberInput { number ->
                onDurationChanged(number)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
        ) {
            Text(
                text = "Budget range",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(12.dp))
            PriceRangeSlider {
                onPriceChanged(it)
            }
        }
    }
}

@Composable
fun PriceRangeSlider(onPriceChanged: (price: Int) -> Unit) {
    var sliderPosition by rememberSaveable { mutableFloatStateOf(600000f) }
    val budgetRangeInRupiah = sliderPosition.toInt()

    val numberFormat = NumberFormat.getCurrencyInstance()
    numberFormat.maximumFractionDigits = 0
    numberFormat.currency = Currency.getInstance("IDR")

    Column {
        Column {
            Slider(
                value = sliderPosition,
                onValueChange = {
                    onPriceChanged(it.toInt())
                    sliderPosition = it
                },
                valueRange = 0f..5000000f
            )
        }
        Text(
            text = numberFormat.format(budgetRangeInRupiah),
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
                onValueChange = {
                    sliderPosition = it
                },
                valueRange = 0f..5f,
                steps = 5
            )
        }
        Text(
            text = "$sliderPosition bintang",
            fontWeight = FontWeight.Bold,
        )
    }
}
