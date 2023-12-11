package com.ch2_ps397.destinology.ui.screen.discovery

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.R
import com.ch2_ps397.destinology.ui.components.cards.DestinologyDiscoveryCategoryCard
import com.ch2_ps397.destinology.ui.components.cards.DestinologyPlaceCard
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologyBottomBarNavigation
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologySearchBar
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.OrangeLight
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyDiscoveryScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            DestinologyBottomBarNavigation(navController = navController)
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .background(White)
                            .padding(16.dp)
                    ) {
                        Text(text = "Hi, Lemon.", fontSize = 16.sp, color = Gray)
                        Text(text = "Mari Menjelajah!", fontSize = 24.sp, color = Black)
                        DestinologySearchBar(onSearch = {})
                    }
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(VeryLightGray)
                    .padding(innerPadding)
            ) {
                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        DestinologyDiscoveryCategoryCard(
                            icon = painterResource(id = R.drawable.random_dice),
                            text = "Random"
                        ) {

                        }
                        DestinologyDiscoveryCategoryCard(
                            icon = painterResource(id = R.drawable.urban),
                            text = "Urban"
                        ) {

                        }
                        DestinologyDiscoveryCategoryCard(
                            icon = painterResource(id = R.drawable.forest),
                            text = "Alam"
                        ) {

                        }
                        DestinologyDiscoveryCategoryCard(
                            icon = painterResource(id = R.drawable.culture),
                            text = "Budaya"
                        ) {

                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Tempat popular", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp, start = 16.dp), fontSize = 20.sp)
                        LazyRow(
                            contentPadding = PaddingValues(start = 16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (i in 1..5) {
                                item {
                                    DestinologyPlaceCard(
                                        imageModel = "https://images.unsplash.com/photo-1556375413-f6cdc5e17398?q=80&w=2082&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                        title = "Candi Borobudur",
                                        rating = 4.6f
                                    ) {

                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                }
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Rekomendasi kami", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp, start = 16.dp), fontSize = 20.sp)
                        LazyRow(
                            contentPadding = PaddingValues(start = 16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (i in 1..5) {
                                item {
                                    DestinologyPlaceCard(
                                        imageModel = "https://plus.unsplash.com/premium_photo-1668883189152-d771c402c385?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                        title = "Candi Borobudur",
                                        rating = 4.6f
                                    ) {

                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                }
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = "Lainnya", fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp, start = 16.dp), fontSize = 20.sp)
                        LazyRow(
                            contentPadding = PaddingValues(start = 16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (i in 1..5) {
                                item {
                                    DestinologyPlaceCard(
                                        imageModel = "https://images.unsplash.com/photo-1527838832700-5059252407fa?q=80&w=1898&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                                        title = "Candi Borobudur",
                                        rating = 4.6f
                                    ) {

                                    }
                                    Spacer(modifier = Modifier.width(16.dp))
                                }
                            }
                        }
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}
