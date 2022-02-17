package com.sibdev.firefighter.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sibdev.firefighter.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBar(state: ScaffoldState, scope: CoroutineScope) {
   TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = { IconButton(onClick = { scope.launch { state.drawerState.open() } }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "localized description")
        }},

    )
}