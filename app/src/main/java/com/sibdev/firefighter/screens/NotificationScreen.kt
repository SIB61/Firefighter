package com.sibdev.firefighter.navigation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.DocumentChange
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.models.AlarmModel
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.utils.Screens
import com.sibdev.firefighter.viewModels.NotificationScreenViewModel
import com.sibdev.firefighter.viewModels.NotificationScreenViewModelProvider

@Composable
fun NotificationScreen(nc:NavHostController){
    val context = LocalContext.current
    val viewModel = NotificationScreenViewModelProvider(context = context).create(NotificationScreenViewModel::class.java)
   // val viewModel = NotificationScreenViewModel(context = context)
    val notifications = viewModel.notifications
   Scaffold(topBar = {
       TopAppBar {
           IconButton(onClick = { nc.navigateUp() }) {
               Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
           }
           Text(text = Screens.Alarm.title, fontFamily = fonts, color = Color.White, modifier = Modifier.fillMaxWidth(), fontSize = 20.sp, textAlign = TextAlign.Center)
       }
   }) {


        LazyColumn(modifier = Modifier.fillMaxSize()) {
            for (notification in notifications) {
                item {
                    Box(
                        modifier = Modifier
                            .padding(10.dp)
                            .background(
                                color = MaterialTheme.colors.primary.copy(alpha = 0.15f),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .padding(20.dp)
                            .fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = notification.communityName,
                                fontFamily = fonts,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "informer: " + notification.name+"\n${notification.info}\n${notification.timeStamp.toDate().toString()}",
                                fontFamily = fonts
                            )

                        }
                    }

                }
            }
        }
    }
}