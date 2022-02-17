package com.sibdev.firefighter.components


import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sibdev.firefighter.utils.Screens


@Composable
fun BottomNavigationBar(bottomNavController : NavHostController){
    val screens= listOf(Screens.Alarm,Screens.Precautions,Screens.UrgentSteps)
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
//
    BottomNavigation {
        screens.forEach{  screen ->
            BottomNavigationItem(
                label = { Text(text = screen.title) },
                icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = null) },
                onClick = { bottomNavController.navigate(screen.route) {
                    bottomNavController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                } },
                selected = currentRoute==screen.route,
                alwaysShowLabel = false
            )
        }
    }
}

