package com.ch2_ps397.destinology.ui.screen.scan

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.R
import com.ch2_ps397.destinology.navigation.DestinologyScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyScanLandmarkScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {  }, navigationIcon = { Image(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Navigate up"
            )})
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Scan a landmark", fontWeight = FontWeight.Bold)
            ModalBottomSheet(onDismissRequest = { /*TODO*/ }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(DestinologyScreens.DestinologyCameraScreen.name)
                            }
                            .padding(16.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.baseline_photo_camera_24), contentDescription = "Ambil gambar")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Gunakan kamera"
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(DestinologyScreens.DestinologyCameraScreen.name)
                            }
                            .padding(16.dp)
                    ) {
                        Image(painter = painterResource(id = R.drawable.baseline_image_24), contentDescription = "Ambil gambar")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Upload gambar"
                        )
                    }
                }
            }
        }
    }
}