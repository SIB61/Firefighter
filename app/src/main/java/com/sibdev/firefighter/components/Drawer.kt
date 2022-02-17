package com.sibdev.firefighter.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.utils.Screens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Drawer(nc: NavHostController, state: ScaffoldState, scope: CoroutineScope, logOut:()->Unit) {

    val screens = listOf(
        Screens.Home,
        Screens.Profile,
        Screens.Settings,
        Screens.Logout
    )
    val backStackEntry by nc.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    Column() {
        screens.forEach {
            DrawerItem(item = it, selected = currentRoute == it.route, onItemClick = { screen ->
                if(screen is Screens.Logout){
                    logOut()
                }
                else
                nc.navigate(screen.route) {
                    nc.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch { state.drawerState.close() }
            })
            Divider()

        }
    }
}


@Composable
fun DrawerItem(item: Screens, selected: Boolean, onItemClick: (Screens) -> Unit) {
    val background = if (selected) Color.Black.copy(0.1f) else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = background, shape = RoundedCornerShape(10.dp))
            .clickable {
                onItemClick(item)
            }
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
        ) {
        Spacer(modifier = Modifier.width(20.dp))
        Icon(painter = painterResource(id = item.icon), contentDescription = null)
        Text(text = " " + item.title)
    }
}
