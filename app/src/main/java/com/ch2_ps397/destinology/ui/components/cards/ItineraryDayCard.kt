package com.ch2_ps397.destinology.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun ItineraryDayCard(isActive: Boolean, day: String, date: String, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isActive) Orange else White)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Text(
            text = day,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = if (isActive) White else Black
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = date,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = if (isActive) White else Black
        )
    }
}
