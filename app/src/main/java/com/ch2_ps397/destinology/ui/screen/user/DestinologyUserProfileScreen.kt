package com.ch2_ps397.destinology.ui.screen.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.scaffold.BottomBarNavigation
import com.ch2_ps397.destinology.ui.theme.DarkGray
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.VeryLightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyUserProfileScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "rizkyfirmansyah")
            }, actions = {
                Image(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Options",
                    modifier = Modifier.clickable {
                        navController.navigate(DestinologyScreens.DestinologySettingScreen.name)
                    }
                )
            })
        },
        bottomBar = {
            BottomBarNavigation(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(VeryLightGray)
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            ) {
                AsyncImage(
                    model = "https://unsplash.com/photos/man-in-black-button-up-shirt-ZHvM3XIOHoE",
                    contentDescription = null,
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
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
                        Text(text = "32", fontWeight = FontWeight.Bold, color = DarkGray)
                        Text(text = "Post", fontSize = 12.sp, color = Gray)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "1300", fontWeight = FontWeight.Bold, color = DarkGray)
                        Text(text = "Followers", fontSize = 12.sp, color = Gray)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "568", fontWeight = FontWeight.Bold, color = DarkGray)
                        Text(text = "Following", fontSize = 12.sp, color = Gray)
                    }
                }
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row {
                    Image(imageVector = Icons.Default.Edit, contentDescription = "Edit profile")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Edit Profile")
                }
            }
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Maharani Bahar")
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = Icons.Default.Place,
                        contentDescription = "Address",
                        colorFilter = ColorFilter.tint(Gray)
                    )
                    Text(
                        text = "Jakarta, Indonesia",
                        fontSize = 12.sp,
                        color = Gray
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "The world is my playground, and I'm here to play!",
                    fontSize = 16.sp,
                    color = Gray
                )
            }
            Divider()
        }
    }
}

@Preview
@Composable
fun PreviewUserProfile() {
    DestinologyUserProfileScreen(navController = rememberNavController())
}