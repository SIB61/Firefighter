package com.sibdev.firefighter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sibdev.firefighter.models.User
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.viewModels.ProfileScreenViewModel
import com.sibdev.firefighter.viewModels.ProfileScreenViewModelProvider

@Composable
fun ProfileScreen(){
    val context = LocalContext.current
    val viewModel:ProfileScreenViewModel = ProfileScreenViewModelProvider(context = context).create(ProfileScreenViewModel::class.java)
    val user by viewModel.user.collectAsState(User())

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = rememberImagePainter( user.imageUrl),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Text(text = user.displayName, fontFamily = fonts, fontWeight = FontWeight.SemiBold, fontSize = 25.sp)
        Text(text = user.email, fontFamily = fonts)
        Divider()
        LazyRow(){

        }
    }
}