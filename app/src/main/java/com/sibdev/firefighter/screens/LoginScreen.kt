package com.sibdev.firefighter.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sibdev.firefighter.R
import com.sibdev.firefighter.components.GoogleSignInButton
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.utils.AuthResultContract
import com.sibdev.firefighter.viewModels.LoginScreenViewModel
import com.sibdev.firefighter.viewModels.LoginViewModelProvider


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LoginScreen(navHostController: NavHostController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    var text by remember { mutableStateOf<String?>(null) }

    val loginScreenViewModel = LoginViewModelProvider(context = context).create(LoginScreenViewModel::class.java)
    val isSignedIn by loginScreenViewModel.signedIn.collectAsState()
    val signInRequestCode = 1
    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResultContract()) { task ->
            loginScreenViewModel.signIn(task)
        }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.app_name), fontFamily = fonts, fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        GoogleSignInButton(text = "Sign Up With Google",
            loadingText = "Signing In....",
            onClicked = {authResultLauncher.launch(signInRequestCode)})
    }

    if(isSignedIn) {
        navHostController.navigate("main_screen"){
            popUpTo(0)
        }
    }
}