package com.sibdev.firefighter.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.sibdev.firefighter.models.Community
import com.sibdev.firefighter.models.User
import com.sibdev.firefighter.ui.theme.fonts
import com.sibdev.firefighter.viewModels.ProfileScreenViewModel
import com.sibdev.firefighter.viewModels.ProfileScreenViewModelProvider


@Composable
fun ProfileScreen(profileNavController: NavController){
    val context = LocalContext.current
    val viewModel:ProfileScreenViewModel = ProfileScreenViewModelProvider(context = context).create(ProfileScreenViewModel::class.java)
    val user by viewModel.user.collectAsState(User())
    val communities = viewModel.s


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
        Row(horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { profileNavController.navigate("emergency_number_screen") },
            verticalAlignment = Alignment.CenterVertically
            ) {
            Text(text = "Emergency Numbers", modifier = Modifier.padding(start = 20.dp))
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null , modifier = Modifier.padding(end = 20.dp))
        }
        Divider()
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Your Communities", fontSize = 20.sp, fontFamily = fonts, fontWeight = FontWeight.SemiBold)
        LazyColumn{
            items(communities){
                item: Community ->
                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable { profileNavController.navigate("details_screen") }
                    .background(
                        color = MaterialTheme.colors.primary.copy(0.15f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)
                    ){
                    Column(verticalArrangement = Arrangement.SpaceAround) {
                        Text(text = item.name, fontFamily = fonts, fontWeight = FontWeight.Bold, fontSize = 25.sp)
                        Text(text = item.address, fontFamily = fonts, fontSize = 20.sp)
                    }
                }
            }
            item{
                Box(modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable { profileNavController.navigate("add_community_screen") }
                    .background(
                        color = MaterialTheme.colors.primary.copy(0.5f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(20.dp)){
                    Icon(imageVector = Icons.Default.Add, contentDescription = null,
                        Modifier
                            .size(100.dp)
                            .align(
                                Alignment.Center
                            ))
                }
            }

        }

    }
}

