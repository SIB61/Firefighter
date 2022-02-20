package com.sibdev.firefighter.components

import android.widget.Spinner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Spinner(
    items:List<String>,
    onValueSelected:(value:String,index:Int)->Unit,
    modifier: androidx.compose.ui.Modifier,
){
    var selectedvalue by remember {
        mutableStateOf(items[0])
    }
    var expanded by remember {
        mutableStateOf(false)
    }
    Column(modifier.fillMaxWidth()) {
        TextField(modifier = modifier.fillMaxWidth(),value = selectedvalue, enabled = false , onValueChange = {}, trailingIcon = {
            IconButton(onClick = { expanded=!expanded }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null
                )
            }
        })

            DropdownMenu(expanded = expanded, onDismissRequest = { /*TODO*/ }, modifier = modifier.fillMaxWidth()) {
                items.forEach {
                    DropdownMenuItem(onClick = {
                        expanded = false
                        selectedvalue = it
                        onValueSelected(it,items.indexOf(it))
                    }) {
                        Text(text = it)
                    }
                }
            }


    }
}