package com.ch2_ps397.destinology.ui.components.cards

import android.widget.ImageButton
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun ItineraryPlaceCard(title:String, description: String, address: String ) {
    Card(
        modifier = Modifier.widthIn(max = 300.dp).padding(bottom = 16.dp)
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
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Row {

                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Text(text = "Description", fontSize = 12.sp, color = Gray)
                Text(text = description)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Image(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Itinerary place",
                    modifier = Modifier.size(16.dp)
                )
                Text(text = address, color = Gray, fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewItineraryPlaceCard() {
    ItineraryPlaceCard(
        title = "Museum Ulen Sentalu",
        description = "Museum Ulen Sentalu adalah museum terbaik di dunia.",
        address = "Jl. Boyong KM.25 Kaliurang, Hargobinangun, Yogyakarta"
    )
}