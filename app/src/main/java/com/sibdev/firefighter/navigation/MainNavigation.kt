package com.sibdev.firefighter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sibdev.firefighter.screens.LoginScreen
import com.sibdev.firefighter.screens.MainScreen
import com.sibdev.firefighter.screens.SplashScreen

@Composable
fun MainNavigation(mainNavController: NavHostController){
    NavHost(navController = mainNavController, startDestination = "splash_screen"){
        composable(route = "splash_screen"){
            SplashScreen(navHostController = mainNavController)
        }
        composable(route = "login_screen"){
            LoginScreen(mainNavController)
        }
        composable(route = "main_screen"){
            MainScreen(mainNavController)
        }
        composable(route = "notification_screen"){
           NotificationScreen(mainNavController)
        }
    }
}