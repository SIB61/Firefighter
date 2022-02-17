package com.sibdev.firefighter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sibdev.firefighter.screens.HomeScreen
import com.sibdev.firefighter.screens.ProfileScreen
import com.sibdev.firefighter.screens.SettingsScreen
import com.sibdev.firefighter.utils.Screens

@Composable
fun DrawerNavigation(drawerNavController: NavHostController){
    NavHost(navController = drawerNavController, startDestination = Screens.Home.route){
        composable(route = Screens.Home.route){
            HomeScreen()
        }
        composable(route = Screens.Profile.route){
            ProfileScreen()
        }
        composable(route = Screens.Settings.route){
            SettingsScreen()
        }
    }
}