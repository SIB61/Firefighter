package com.sibdev.firefighter.screens

import android.widget.VideoView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.db.SharedPref
import com.sibdev.firefighter.models.Numbers
import com.sibdev.firefighter.models.User
import com.sibdev.firefighter.viewModels.EmergencyNumberScreenViewModel
import com.sibdev.firefighter.viewModels.EmergencyNumberScreenViewModelProvider

@Composable
fun EmergencyNumberScreen(profileNavController: NavHostController) {
    val vm = EmergencyNumberScreenViewModelProvider().create(EmergencyNumberScreenViewModel::class.java)
    val context = LocalContext.current
    val sharedPref = SharedPref(context = context)
    var number1 by remember { mutableStateOf(sharedPref.number1) }
    var number2 by remember { mutableStateOf(sharedPref.number2) }
    var number3 by remember { mutableStateOf(sharedPref.number3) }
    var number4 by remember { mutableStateOf(sharedPref.number4) }
    var number5 by remember { mutableStateOf(sharedPref.number5) }

//    Repository.userById(Firebase.auth.uid!!).addSnapshotListener { v, e ->
//        val user = v?.toObject(User::class.java)
//        if(user!=null) {
//            number1 = user.number1
//            number2 = user.number2
//            number3 = user.number3
//            number4 = user.number4
//            number5 = user.number5
//        }
//
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = number1,
                label = { Text(text = "Number 1") },
                onValueChange = { number1=it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = number2,
                label = { Text(text = "Number 2") },
                onValueChange = { number2=it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )

            OutlinedTextField(
                value = number3,
                label = { Text(text = "Number 3") },
                onValueChange = { number3=it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = number4,
                label = { Text(text = "Number 4") },
                onValueChange = { number4=it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            OutlinedTextField(
                value = number5,
                label = { Text(text = "Number 5") },
                onValueChange = {number5=it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Text(text = "*These numbers will be informed \nthrough messages in emergency", color = Color.Black.copy(0.25f))
        }
        Button(onClick = {
            sharedPref.setNumber1(number1)
            sharedPref.setNumber2(number2)
            sharedPref.setNumber3(number3)
            sharedPref.setNumber4(number4)
            sharedPref.setNumber5(number5)
            vm.saveEmergencyNumbers(Numbers(number1,number2,number3,number4,number5))
                       profileNavController.navigateUp()
                         },
            Modifier
                .fillMaxWidth()
                .height(60.dp)
                .align(Alignment.BottomCenter)) {
            Text(text = "SAVE NUMBERS")
        }

    }
}