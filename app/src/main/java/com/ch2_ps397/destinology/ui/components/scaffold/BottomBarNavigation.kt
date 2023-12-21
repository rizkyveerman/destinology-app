package com.ch2_ps397.destinology.ui.components.scaffold

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material.icons.twotone.DateRange
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ch2_ps397.destinology.navigation.DestinologyBottomNavigationItem
import com.ch2_ps397.destinology.navigation.DestinologyScreens
import com.ch2_ps397.destinology.ui.theme.Black
import com.ch2_ps397.destinology.ui.theme.LightGray
import com.ch2_ps397.destinology.ui.theme.Indigo
import com.ch2_ps397.destinology.ui.theme.IndigoLight
import com.ch2_ps397.destinology.ui.theme.White


@Composable
fun DestinologyBottomBarNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
    ) {
        val navigationItems = listOf(
            DestinologyBottomNavigationItem(
                title = "My Plan",
                icon = Icons.TwoTone.DateRange,
                screen = DestinologyScreens.DestinologyPlanScreen
            ),
            DestinologyBottomNavigationItem(
                title = "Scan",
                icon = Icons.TwoTone.AddCircle,
                screen = DestinologyScreens.DestinologyCameraScreen
            ),
            DestinologyBottomNavigationItem(
                title = "Discovery",
                icon = Icons.TwoTone.Search,
                screen = DestinologyScreens.DestinologyDiscoveryScreen
            ),
            DestinologyBottomNavigationItem(
                title = "Profile",
                icon = Icons.TwoTone.AccountCircle,
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
                    Image(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        colorFilter = ColorFilter.tint(Indigo)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = IndigoLight,
                    selectedIconColor = Color.White,
                    unselectedIconColor = LightGray,
                ),
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = false
            )

        }
    }
}