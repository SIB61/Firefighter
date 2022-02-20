package com.sibdev.firefighter.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.DrawerState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sibdev.firefighter.components.Drawer
import com.sibdev.firefighter.components.TopBar
import com.sibdev.firefighter.navigation.DrawerNavigation
import com.sibdev.firefighter.navigation.MainNavigation
import com.sibdev.firefighter.viewModels.MainScreenViewModel
import com.sibdev.firefighter.viewModels.MainScreenViewModelProvider

@Composable
fun MainScreen(mainNavController: NavHostController) {
    val context= LocalContext.current
    val mainScreenViewModel = MainScreenViewModelProvider(context = context ).create(MainScreenViewModel::class.java)
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val drawerNavController= rememberNavController()
    val isLoggedOut by mainScreenViewModel.isLoggedOut.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize(),
        scaffoldState = state,
        drawerContent = { Drawer(nc = drawerNavController, state = state, scope = scope, logOut = { mainScreenViewModel.logOut() } ) },
        topBar = { TopBar(state = state, scope = scope,mainNavController)}
        ) {
        DrawerNavigation(drawerNavController = drawerNavController)
        if(isLoggedOut){
            mainNavController.navigate("login_screen"){
                popUpTo(0)
            }
        }
    }
}