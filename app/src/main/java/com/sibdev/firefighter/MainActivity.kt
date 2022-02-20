package com.sibdev.firefighter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.RemoteMessage
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.navigation.MainNavigation
import com.sibdev.firefighter.screens.LoginScreen
import com.sibdev.firefighter.service.MyFirebaseMessagingService
import com.sibdev.firefighter.ui.theme.FirefighterTheme
import com.sibdev.firefighter.utils.foregroundStartService
import com.sibdev.firefighter.utils.vibrate
import com.sibdev.firefighter.viewModels.LoginScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirefighterTheme {
                // A surface container using the 'background' color from the theme
                val mainNavController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainNavigation(mainNavController = mainNavController)
                }
            }
        }

       // vibrate()
    }
}
