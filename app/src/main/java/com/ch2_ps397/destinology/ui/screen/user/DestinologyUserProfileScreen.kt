package com.ch2_ps397.destinology.ui.screen.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Place
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.button.SmallButton
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologyBottomBarNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyUserProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "@rizkyfirmansyah")
                },
                actions = {
                    Image(
                        imageVector = Icons.TwoTone.Settings,
                        contentDescription = "Options",
                        modifier = Modifier.clickable {
                            navController.navigate(DestinologyScreens.DestinologySettingScreen.name)
                        }
                    )
                },
            )
        },
        bottomBar = {
            DestinologyBottomBarNavigation(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 32.dp, 16.dp, 0.dp)
            ) {
                AsyncImage(
                    model = "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8YXZhdGFyfGVufDB8fDB8fHww",
                    contentDescription = null,
                    modifier = Modifier
                        .width(96.dp)
                        .height(96.dp)
                        .clip(CircleShape)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "32",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(text = "Post")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "1300",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(text = "Followers")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "568",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(text = "Following")
                    }
                }
            }
            Column(
                modifier = Modifier.padding(16.dp, 16.dp, 16.dp)
            ) {
                SmallButton(text = "Edit profile") {

                }
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Rizky F",
                    fontWeight = FontWeight.Bold,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.TwoTone.Place,
                        contentDescription = "Address",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Jakarta, Indonesia",
                        fontSize = 12.sp,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "The world is my playground, and I'm here to play!",
                    fontSize = 16.sp,
                )
            }
            Divider()
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Text(
                        text = "No post yet",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewUserProfile() {
    DestinologyUserProfileScreen(navController = rememberNavController())
}