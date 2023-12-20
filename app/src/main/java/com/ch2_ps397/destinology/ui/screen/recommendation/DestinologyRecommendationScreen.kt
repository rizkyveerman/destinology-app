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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.di.Injection
import com.ch2_ps397.destinology.core.model.MItinerary
import com.ch2_ps397.destinology.core.utils.Resource
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.button.DestinologyFloatingButton
import com.ch2_ps397.destinology.ui.components.button.DestinologyPrimaryButton
import com.ch2_ps397.destinology.ui.components.cards.ItineraryDayCard
import com.ch2_ps397.destinology.ui.components.cards.ItineraryPlaceTimeline
import com.ch2_ps397.destinology.ui.components.form.DestinationInputForm
import com.ch2_ps397.destinology.ui.components.imagery.ImageBackground
import com.ch2_ps397.destinology.ui.theme.VeryLightGray
import com.ch2_ps397.destinology.ui.theme.White

@Composable
fun DestinologyRecommendationScreen(
    navController: NavController,
    destinologyRecommendationViewModel: DestinologyRecommendationViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideItineraryRepository(
                LocalContext.current
            ),
            Injection.provideLandmarkRepository(
                LocalContext.current
            ),
            Injection.provideUserRepository(
                LocalContext.current
            )
        )
    )
) {

    destinologyRecommendationViewModel
        .resource.collectAsState(initial = Resource.Loading)
        .value.let { resource ->
            when(resource) {
                is Resource.Idle -> {
                    DestinologyGenerateItineraryScreen { city, duration, budget ->
                        destinologyRecommendationViewModel.generateNewItinerary(city, duration, budget)
                    }
                }
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    DestinologySucessRecommend(navController, data = resource.data)
                }
                is Resource.Error -> {
                    DestinologyGenerateItineraryScreen { city, duration, budget ->
                        destinologyRecommendationViewModel.generateNewItinerary(city, duration, budget)
                    }
                }
            }

    }
}


@Composable
fun DestinologyGenerateItineraryScreen(
    onGenerate: (
    selectedCity: String,
    selectedDuration: Int,
    selectedBudget: Int
) -> Unit) {

    var selectedCity by rememberSaveable {
        mutableStateOf("Yogyakarta")
    }
    var selectedDuration by rememberSaveable {
        mutableIntStateOf(3)
    }
    var selectedBudget by rememberSaveable {
        mutableIntStateOf(600000)
    }

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
            DestinationInputForm(
                onCityChanged = {
                    selectedCity = it

                },
                onDurationChanged = {
                    selectedDuration = it
                },
                {
                    selectedBudget = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            DestinologyPrimaryButton(enabled = true, text = "Generate") {
                onGenerate(selectedCity, selectedDuration, selectedBudget)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologySucessRecommend(navController: NavController, data: List<MItinerary>?) {

    var dayPlanState by remember {
        mutableIntStateOf(1)
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
                ItineraryDayCard(isActive = (dayPlanState == 1), "Day 1", "12 Des") {
                    dayPlanState = 1
                }
                ItineraryDayCard(isActive = (dayPlanState == 2), "Day 2", "13 Des") {
                    dayPlanState = 2
                }
                ItineraryDayCard(isActive = (dayPlanState == 3), "Day 3", "14 Des") {
                    dayPlanState = 3
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
                    1 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            var hours = 9
                            if (data != null) {
                                val day1 = data.filter { it.day == 1 }
                                items(day1) { mItinerary ->
                                    hours++
                                    ItineraryPlaceTimeline(hours, mItinerary) {}
                                }
                            }
                        }
                    }
                    2 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            var hours = 9
                            if (data != null) {
                                val day2 = data.filter { it.day == 2 }
                                items(day2) { mItinerary ->
                                    hours++
                                    ItineraryPlaceTimeline(hours, mItinerary) {}
                                }
                            }
                        }
                    }
                    3 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            var hours = 9
                            if (data != null) {
                                val day3 = data.filter { it.day == 3 }
                                items(day3) { mItinerary ->
                                    hours++
                                    ItineraryPlaceTimeline(hours, mItinerary) {}
                                }
                            }
                        }
                    }
                }
            }

        }

    }
}
