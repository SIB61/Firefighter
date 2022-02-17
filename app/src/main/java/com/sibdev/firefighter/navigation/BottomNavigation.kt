package com.sibdev.firefighter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sibdev.firefighter.screens.AlarmScreen
import com.sibdev.firefighter.screens.PrecautionScreen
import com.sibdev.firefighter.screens.UrgentStepScreen
import com.sibdev.firefighter.utils.Screens

@Composable
fun BottomNavigation(bottomNavController: NavHostController) {
    NavHost(navController = bottomNavController, startDestination = Screens.Alarm.route) {
        composable(Screens.Alarm.route) {
             AlarmScreen()
        }
        composable(Screens.Precautions.route) {
             PrecautionScreen()
        }
        composable(Screens.UrgentSteps.route) {
             UrgentStepScreen()
        }
    }
}