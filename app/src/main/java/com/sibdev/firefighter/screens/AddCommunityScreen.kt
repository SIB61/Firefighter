package com.sibdev.firefighter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sibdev.firefighter.navigation.AddCommunityNavigation

@Composable
fun AddCommunityScreen(profileNavController: NavHostController) {
    var i by remember {
        mutableStateOf(0)
    }
    val nc = rememberNavController()
    Column(Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = i, Modifier.height(50.dp)) {
            Tab(selected = i == 0,
                onClick = {
                    i = 0
                    if(nc.currentDestination?.route!="join_community")
                    nc.navigate("join_community"){
                        popUpTo(0)
                    }
                }) {
                Text(text = "Join community")
            }
            Tab(selected = i == 1,
                onClick = {
                    i = 1
                    if(nc.currentDestination?.route!="add_community")
                    nc.navigate("add_community"){
                        popUpTo(0)
                    }}){
                Text(text = "Add community")
            }
        }
        AddCommunityNavigation(nc = nc)
    }


}