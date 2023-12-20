package com.ch2_ps397.destinology.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.twotone.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ch2_ps397.destinology.core.model.MItinerary
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun ItineraryPlaceCard(placeName:String, price: Int, rating: Float, category: String, regeneratePlace: () -> Unit) {
    Card(
        modifier = Modifier
            .widthIn(max = 300.dp)
            .padding(bottom = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .background(White)
                .clickable {

                }
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = placeName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .clip(CircleShape)
                        .background(VeryLightGray)
                        .clickable {
                        }
                ) {
                    Image(
                        imageVector = Icons.TwoTone.Refresh,
                        contentDescription = "Share",
                        colorFilter = ColorFilter.tint(Gray)
                    )
                }
            }
            Column {
                Text(text = "Category", fontSize = 12.sp, color = Gray)
                Text(text = category)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Itinerary place",
                        modifier = Modifier.size(16.dp),
                        colorFilter = ColorFilter.tint(Orange)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = rating.toString(), color = Gray )
                }
                Spacer(modifier = Modifier.width(24.dp))
                if (price == 0) {
                    DestinologyLabel(status = true, text = "Gratis")
                } else {
                    Text(text = "IDR $price", color = Black, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun ItineraryPlaceTimeline(hours: Int, mItinerary: MItinerary, regeneratePlace: () -> Unit) {
    val timeConvention = if (hours < 12) "AM" else "PM"
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "$hours.00 $timeConvention", color = Gray, fontSize = 14.sp)
        Spacer(modifier = Modifier.width(8.dp))
        ItineraryPlaceCard(
            placeName = mItinerary.placeName,
            category = mItinerary.category,
            price = mItinerary.price,
            rating = mItinerary.rating
        ) {
            regeneratePlace()
        }
    }
}