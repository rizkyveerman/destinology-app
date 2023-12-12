package com.ch2_ps397.destinology.ui.screen.discovery

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ExitToApp
import androidx.compose.material.icons.twotone.Place
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ch2_ps397.destinology.ui.components.button.Button
import com.ch2_ps397.destinology.ui.components.fields.DestinologyTextInput
import com.ch2_ps397.destinology.ui.components.imagery.ImageBackground
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.Orange
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyPlaceDetailsScreen(navController: NavController, navBackStackEntry: String?) {
    val ratingStars = rememberSaveable { mutableIntStateOf(3) }
    val reviewComment = rememberSaveable { mutableStateOf("") }
    var showRatingialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ImageBackground("https://images.unsplash.com/photo-1682685797439-a05dd915cee9?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
        Box(modifier = Modifier.padding(16.dp)) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = White
                    ),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                            ) {
                                Text(
                                    text = "Museum Ulen Nutelu",
                                    fontWeight = FontWeight.Bold,
                                    color = Black
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        imageVector = Icons.TwoTone.Place,
                                        contentDescription = "Address",
                                        colorFilter = ColorFilter.tint(Gray),
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = "Jl. Kaliurang - Yogyakarta",
                                        color = Gray
                                    )
                                }
                            }
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
                                    imageVector = Icons.TwoTone.ExitToApp,
                                    contentDescription = "Like",
                                    colorFilter = ColorFilter.tint(Gray)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", color = Black)
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(enabled = true, text = "Beri rating") {
                    showRatingialog = true
                }

                if (showRatingialog) {
                    Dialog(
                        onDismissRequest = { showRatingialog = false },
                        properties = DialogProperties(
                            dismissOnBackPress = true,
                            dismissOnClickOutside = true
                        )
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(White)
                                    .padding(16.dp),
                            )  {
                                Text(
                                    text = "Beri rating",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.background(Color.Transparent)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                //TODO rating stars
                                Row {
                                    Image(
                                        colorFilter = if (ratingStars.intValue >= 1) ColorFilter.tint(Orange) else ColorFilter.tint(
                                            Gray) ,
                                        imageVector = Icons.TwoTone.Star,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            ratingStars.intValue = 1
                                        }
                                    )
                                    Image(
                                        colorFilter = if (ratingStars.intValue >= 2) ColorFilter.tint(Orange) else ColorFilter.tint(
                                            Gray) ,
                                        imageVector = Icons.TwoTone.Star,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            ratingStars.intValue = 2
                                        }
                                    )
                                    Image(
                                        colorFilter = if (ratingStars.intValue >= 3) ColorFilter.tint(Orange) else ColorFilter.tint(
                                            Gray) ,
                                        imageVector = Icons.TwoTone.Star,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            ratingStars.intValue = 3
                                        }
                                    )
                                    Image(
                                        colorFilter = if (ratingStars.intValue >= 4) ColorFilter.tint(Orange) else ColorFilter.tint(
                                            Gray) ,
                                        imageVector = Icons.TwoTone.Star,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            ratingStars.intValue = 4
                                        }
                                    )
                                    Image(
                                        colorFilter = if (ratingStars.intValue >= 5) ColorFilter.tint(Orange) else ColorFilter.tint(
                                            Gray) ,
                                        imageVector = Icons.TwoTone.Star,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            ratingStars.intValue = 5
                                        }
                                    )
                                }
                                Spacer(modifier = Modifier.height(16.dp))
                                DestinologyTextInput(
                                    valueState = reviewComment,
                                    labelId = "Beri komentar",
                                    enabled = true,
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(enabled = true, text = "Submit") {
                                    showRatingialog = false
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPlaceDetails() {
    DestinologyPlaceDetailsScreen(navController = rememberNavController(), navBackStackEntry = "" )
}