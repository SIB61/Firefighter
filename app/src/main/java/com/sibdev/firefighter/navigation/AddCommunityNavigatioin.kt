package com.sibdev.firefighter.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.db.SharedPref
import com.sibdev.firefighter.models.Community
import com.sibdev.firefighter.models.Request
import kotlin.random.Random

@Composable
fun AddCommunityNavigation(nc: NavHostController) {
    NavHost(navController = nc, startDestination = "join_community") {
        composable("join_community") {
            JoinOneSegment()
        }
        composable("add_community") {
            AddNewSegment()
        }
    }
}

@Composable
fun JoinOneSegment() {
    val context = LocalContext.current
    var v by remember {
        mutableStateOf("")
    }
    var e by remember {
        mutableStateOf("")
    }
    val sharedPref = SharedPref(context = context)
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            Modifier
                .width(300.dp)
                .align(Alignment.Center)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = v,
                onValueChange = { v = it },
                label = { Text(text = "Community code") },
                singleLine = true
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = e,
                onValueChange = { e = it },
                label = { Text(text = "Your exact location") },
                singleLine = true
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                if (v.isNotEmpty() && e.isNotEmpty()) {
                    val request =
                        Request(Firebase.auth.uid!!, sharedPref.name, e, sharedPref.imageUrl)
                    Repository.request(id = e).add(request).addOnSuccessListener {
                        Toast.makeText(context, "Request has been sent", Toast.LENGTH_SHORT).show()
                    }
                }

            }, Modifier.fillMaxWidth()) {
                Text(text = "REQUEST")
            }
        }
    }
}

@Composable
fun AddNewSegment() {
    var a by remember {
        mutableStateOf("")
    }
    var n by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = n,
                onValueChange = { n = it },
                label = { Text(text = "Community name") },
                singleLine = true
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                value = a,
                onValueChange = { a = it },
                label = { Text(text = "Community Address") })
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                val sharedPref = SharedPref(context = context)
                val id = Firebase.auth.uid +(1..100).random()

                if (a.isNotEmpty() && n.isNotEmpty()) {
                    val community = Community(id, Firebase.auth.uid!!, n, a)
                    Repository.Communities.document(id).set(community).addOnSuccessListener {
                        Repository.MyCommunities.add(community).addOnSuccessListener {
                            Toast.makeText(context, "Community added", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else Toast.makeText(context, "enter name and address", Toast.LENGTH_SHORT).show()

            }, Modifier.fillMaxWidth()) {
                Text(text = "SAVE")
            }
        }
    }
}
