package com.sibdev.firefighter.screens

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.sibdev.firefighter.components.Spinner
import com.sibdev.firefighter.models.Community
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.utils.hasPermissions
import com.sibdev.firefighter.utils.vibrate
import com.sibdev.firefighter.viewModels.AlarmScreenViewModel
import com.sibdev.firefighter.viewModels.AlarmScreenViewModelProvider

@Composable
fun AlarmScreen() {
    val context = LocalContext.current
    val viewModel =
        AlarmScreenViewModelProvider(context = context).create(AlarmScreenViewModel::class.java)
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { isGranted ->
        if (!isGranted.containsValue(false)) {
            // Permission Accepted: Do something
            Log.d("ExampleScreen", "PERMISSION GRANTED")
        } else {
            // Permission Denied: Do something
            Log.d("ExampleScreen", "PERMISSION DENIED")
        }
    }
var d by remember {
    mutableStateOf("")
}
    var i by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.fillMaxSize()) {
            Spinner(
                items = viewModel.names,
                onValueSelected = { value, index ->
                    i=index
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(value = d, onValueChange = {  d=it },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.33f)
                    .padding(10.dp),
                placeholder = { Text(text = "অতিরিক্ত বিবরণ...", fontFamily = fonts) }
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    val PERMISSIONS = arrayOf(
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.VIBRATE,
                        Manifest.permission.CALL_PHONE
                    )
                    if(context.hasPermissions(PERMISSIONS))
                    {
                        viewModel.community=viewModel.communities[i]
                        viewModel.info=d
                      viewModel.alart()
                    }
                    else
                    {
                        launcher.launch(PERMISSIONS)
                    }
                },
                modifier = Modifier
                    .size(200.dp)
                    .align(CenterHorizontally),
                border = BorderStroke(
                    50.dp, brush = Brush.linearGradient(
                        listOf(
                            Color.Red, MaterialTheme.colors.primary,
                            Color.Red, MaterialTheme.colors.primary
                        )
                    )
                ),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red
                )
            ) {
                Text(
                    text = "এলার্ম!",
                    fontFamily = fonts,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = Color.White
                )
            }
            Text(text = "*মজা করার জন্য এটা করবেন না*", fontFamily = fonts, color = Color.Red, modifier = Modifier.align(CenterHorizontally))

        }


    }
}