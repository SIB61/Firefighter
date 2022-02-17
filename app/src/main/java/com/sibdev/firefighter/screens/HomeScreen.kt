package com.sibdev.firefighter.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sibdev.firefighter.components.BottomNavigationBar
import com.sibdev.firefighter.components.TopBar

@Composable
fun HomeScreen(){
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val bottomNavController= rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = state,
        bottomBar = { BottomNavigationBar(bottomNavController = bottomNavController)}
    )
         {
       com.sibdev.firefighter.navigation.BottomNavigation(bottomNavController = bottomNavController)
    }
}