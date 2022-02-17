package com.sibdev.firefighter.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.R
import com.sibdev.firefighter.ui.theme.fonts
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navHostController: NavHostController){
    val scope= rememberCoroutineScope()
    val auth=Firebase.auth
    scope.launch {
        delay(2000)
        navHostController.navigate(
            if(auth.currentUser!=null) "main_screen"
            else "login_screen"
        ){
            popUpTo(0)
        }
    }
Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
    Text(text = stringResource(id = R.string.app_name), fontFamily = fonts, fontSize = 50.sp, fontWeight = FontWeight.Bold)
}

}