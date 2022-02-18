package com.sibdev.firefighter.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sibdev.firefighter.R
import com.sibdev.firefighter.components.GradientButton
import com.sibdev.firefighter.components.Spinner
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.viewModels.AlarmScreenViewModel
import com.sibdev.firefighter.viewModels.AlarmScreenViewModelProvider

@Composable
fun AlarmScreen(){
    val context = LocalContext.current
    val viewModel = AlarmScreenViewModelProvider(context = context).create(AlarmScreenViewModel::class.java)
    var expanded by remember {
        mutableStateOf(true)
    }
    var community by remember {
        mutableStateOf("")
    }
    var des by remember {
        mutableStateOf("")
    }
    val items = listOf<String>("Sabit","Gopal","Choia")
    Box(modifier = Modifier.fillMaxSize()

    ){
        Column(Modifier.fillMaxSize()) {
            Spinner(items = items, onValueSelected = {community=it}, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = des, onValueChange = {des=it},
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.33f)
                    .padding(10.dp),
            placeholder = { Text(text = "Additional Description with alarm...")}
                )
            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = {  },
                modifier = Modifier
                    .size(200.dp)
                    .align(CenterHorizontally),
                border = BorderStroke(10.dp, brush = Brush.linearGradient(listOf(Color.Red, Color.Green,
                    Color.Blue, Color.Yellow))),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Red
                )
            ) {
                Text(text = "Fire\nAlarm!", fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 30.sp)
            }

        }


    }
}