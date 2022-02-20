package com.sibdev.firefighter.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.DocumentChange
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.db.SharedPref
import com.sibdev.firefighter.models.Community
import com.sibdev.firefighter.models.Request
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.viewModels.CommunityScreenViewModel
import com.sibdev.firefighter.viewModels.CommunityScreenViewModelProvider

@Composable
fun CommunityScreen(){
    val context = LocalContext.current
    val viewModel = CommunityScreenViewModelProvider(context = context).create(CommunityScreenViewModel::class.java)
    val sharedPref = SharedPref(context = context)
    val community = viewModel.community
    val members = viewModel.members
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = community.name, fontFamily = fonts, fontSize = 25.sp)
        SelectionContainer() {
            Text(text = sharedPref.community, fontFamily = fonts, fontSize = 14.sp)
        }
        Text(text = "members", fontFamily = fonts, fontSize = 20.sp)
        LazyColumn{
            items(members){
                member->
                  Column(Modifier.fillMaxWidth()) {
                      Text(text = member.name, fontFamily = fonts, fontWeight = FontWeight.Bold)
                      Text(text = member.location, fontFamily = fonts)
                      Divider()
                  }
            }
        }
    }
}