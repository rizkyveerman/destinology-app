package com.ch2_ps397.destinology.ui.components.scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ch2_ps397.destinology.navigation.DestinologyBottomNavigationItem
import com.ch2_ps397.destinology.navigation.DestinologyScreens


@Composable
fun BottomBarNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        val navigationItems = listOf(
            DestinologyBottomNavigationItem(
                title = "My Plan",
                icon = Icons.Default.Search,
                screen = DestinologyScreens.DestinologyPlanScreen
            ),
            DestinologyBottomNavigationItem(
                title = "Scan",
                icon = Icons.Rounded.AddCircle,
                screen = DestinologyScreens.DestinologyScanLandmarkScreen
            ),
            DestinologyBottomNavigationItem(
                title = "Community",
                icon = Icons.Default.FavoriteBorder,
                screen = DestinologyScreens.DestinologyCommunityScreen
            ),
            DestinologyBottomNavigationItem(
                title = "Profile",
                icon = Icons.Default.Person,
                screen = DestinologyScreens.DestinologyUserProfileScreen
            ),
        )

        navigationItems.map {item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.name,
                onClick = {
                    navController.navigate(item.screen.name) {
                        popUpTo(navController.graph.findStartDestination().id)
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Black,
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                ),
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = false
            )

        }
    }
}