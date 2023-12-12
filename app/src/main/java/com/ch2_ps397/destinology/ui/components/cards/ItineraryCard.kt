package com.ch2_ps397.destinology.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Edit
import androidx.compose.material.icons.twotone.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyItineraryCard(imageModel: String, title: String, rating: Float, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .widthIn(max = 350.dp),
        colors = CardDefaults.cardColors(
            containerColor = White,
            contentColor = Black,
        )
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = imageModel,
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)

                Column(
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    Text(text = "Description", fontSize = 14.sp, color = Gray)
                    Text(text = "Liburan akhir tahun 2023.")
                }
            }
            Row {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .clip(CircleShape)
                        .clickable {

                        }
                ) {
                    Image(
                        imageVector = Icons.TwoTone.Share,
                        contentDescription = "Like",
                        colorFilter = ColorFilter.tint(Gray)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .clip(CircleShape)
                        .clickable {

                        }
                ) {
                    Image(
                        imageVector = Icons.TwoTone.Edit,
                        contentDescription = "Like",
                        colorFilter = ColorFilter.tint(Gray)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewItineraryCard() {
    DestinologyItineraryCard(
        imageModel = "https://images.unsplash.com/photo-1556375413-f6cdc5e17398?q=80&w=2082&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        title = "Itinerary 1",
        rating = 4.6f
    ) {
        
    }
}