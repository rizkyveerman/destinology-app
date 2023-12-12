package com.ch2_ps397.destinology.ui.screen.recommendation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ch2_ps397.destinology.core.di.Injection
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.button.Button
import com.ch2_ps397.destinology.ui.components.button.DestinologyFloatingButton
import com.ch2_ps397.destinology.ui.components.cards.ItineraryDayCard
import com.ch2_ps397.destinology.ui.components.cards.ItineraryPlaceCard
import com.ch2_ps397.destinology.ui.components.form.DestinationInputForm
import com.ch2_ps397.destinology.ui.components.imagery.ImageBackground
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyRecommendationScreen(
    navController: NavController,
    destinologyRecommendationViewModel: DestinologyRecommendationViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(LocalContext.current))
    )
) {

    var generateForm by remember {
        mutableStateOf(true)
    }

    // TODO delete this once you implement API call
    DestinologyGenerateItineraryScreen {
        generateForm = false
    }
    // TODO delete this once you implement API call
    if (!generateForm) {
        DestinologySucessRecommend(navController)
    }

    // TODO uncomment this once you implement API call
//    destinologyRecommendationViewModel
//        .resource.collectAsState(initial = Resource.Loading)
//        .value.let { resource ->
//
//            when(resource) {
//                is Resource.Idle -> {
//                    DestinologyGenerateItineraryScreen {
//                        destinologyRecommendationViewModel.generateNewItinerary()
//                    }
//                }
//
//                is Resource.Loading -> {
//
//                }
//
//                is Resource.Success -> {
//                    DestinologySucessRecommend(navController)
//                }
//                is Resource.Error -> {
//                    Text(text = resource.message)
//                }
//            }
//
//    }
}


@Composable
fun DestinologyGenerateItineraryScreen(onGenerate: () -> Unit) {
    ImageBackground()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Choose your preferred\ndestination and style to\nget started",
                color = White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            DestinationInputForm()
            Spacer(modifier = Modifier.height(16.dp))
            Button(enabled = true, text = "Generate") {
                onGenerate()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologySucessRecommend(navController: NavController) {

    var dayPlanState by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Our Recommendations", fontWeight = FontWeight.Bold) },
            )
        },
        floatingActionButton = {
            DestinologyFloatingButton(
                content = {
                    Text(text = "Gunakan", modifier = Modifier.padding(16.dp))
                }
            ) {
                //TODO save this plan to ROOM
                navController.navigate(DestinologyScreens.DestinologyPlanScreen.name) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(VeryLightGray)
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                ItineraryDayCard(isActive = (dayPlanState == 0), "Day 1", "12 Des") {
                    dayPlanState = 0
                }
                ItineraryDayCard(isActive = (dayPlanState == 1), "Day 2", "13 Des") {                    dayPlanState = 0
                    dayPlanState = 1
                }
                ItineraryDayCard(isActive = (dayPlanState == 2), "Day 3", "14 Des") {
                    dayPlanState = 2
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                when (dayPlanState) {
                    0 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (i in 1..4) {
                                item {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(text = "10.00 AM", color = Gray)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        ItineraryPlaceCard(
                                            title = "Museum Ulen Sentalu 1",
                                            description = "Museum keren kalo mau liat patung Squidward bisa kesini.",
                                            address = "Jl. Boyong KM.25 Kaliurang, Hargobinangun, Yogyakarta"
                                        )
                                    }
                                }
                            }
                        }
                    }
                    1 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (i in 1..4) {
                                item {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(text = "10.00 AM", color = Gray)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        ItineraryPlaceCard(
                                            title = "Museum Ulen Sentalu 2",
                                            description = "Museum keren kalo mau liat patung Squidward bisa kesini.",
                                            address = "Jl. Boyong KM.25 Kaliurang, Hargobinangun, Yogyakarta"
                                        )
                                    }
                                }
                            }
                        }
                    }
                    2 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            for (i in 1..4) {
                                item {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(text = "10.00 AM", color = Gray)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        ItineraryPlaceCard(
                                            title = "Museum Ulen Sentalu 3",
                                            description = "Museum keren kalo mau liat patung Squidward bisa kesini.",
                                            address = "Jl. Boyong KM.25 Kaliurang, Hargobinangun, Yogyakarta"
                                        )
                                    }
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
fun PreviewRecommendationScreen() {
    DestinologyRecommendationScreen(navController = rememberNavController())
}