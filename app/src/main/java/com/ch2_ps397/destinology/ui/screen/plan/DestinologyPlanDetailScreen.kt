package com.ch2_ps397.destinology.ui.screen.plan

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ch2_ps397.destinology.core.model.MItinerary
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.components.cards.ItineraryDayCard
import com.ch2_ps397.destinology.ui.components.cards.ItineraryPlaceCard
import com.ch2_ps397.destinology.ui.components.cards.ItineraryPlaceTimeline
import com.ch2_ps397.destinology.ui.components.scaffold.DestinologyAppBarNavigationIcon
import com.ch2_ps397.destinology.ui.theme.DarkGray
import com.ch2_ps397.destinology.ui.theme.Gray
import com.ch2_ps397.destinology.ui.theme.VeryLightGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyPlanDetailScreen(navController: NavController, navBackStackEntry: String?) {

    var dayPlanState by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Itinerary 1")
                },
                navigationIcon = {
                    DestinologyAppBarNavigationIcon {
                        navController.navigate(DestinologyScreens.DestinologyPlanScreen.name) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
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
                Text(text = "Timeline", fontWeight = FontWeight.Bold, color = DarkGray)
                Spacer(modifier = Modifier.height(24.dp))

                when (dayPlanState) {
                    0 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val mItinerary = MItinerary(
                                placeName = "mItinerary.placeName",
                                category = "mItinerary.category",
                                price = 1000,
                                rating = 4.5f,
                                day = 3
                            )
                            for (i in 1..4) {
                                item {
//                                    ItineraryPlaceTimeline(mItinerary = mItinerary)
                                }
                            }
                        }
                    }
                    1 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val mItinerary = MItinerary(
                                placeName = "mItinerary.placeName",
                                category = "mItinerary.category",
                                price = 1000,
                                rating = 4.5f,
                                day = 3
                            )
                            for (i in 1..4) {
                                item {
//                                    ItineraryPlaceTimeline(mItinerary = mItinerary)
                                }
                            }
                        }
                    }
                    2 -> {
                        LazyColumn(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val mItinerary = MItinerary(
                                placeName = "mItinerary.placeName",
                                category = "mItinerary.category",
                                price = 1000,
                                rating = 4.5f,
                                day = 3
                            )
                            for (i in 1..4) {
                                item {
//                                    ItineraryPlaceTimeline(mItinerary = mItinerary)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}