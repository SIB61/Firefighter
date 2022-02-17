package com.sibdev.firefighter.viewModels

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainScreenViewModel(context: Context):ViewModel(){
    val auth = Firebase.auth

    private val _isLoggedOut:MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoggedOut:StateFlow<Boolean> = _isLoggedOut

    fun logOut(){
        auth.signOut()
        _isLoggedOut.value=true
    }
}
class MainScreenViewModelProvider(val context: Context):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainScreenViewModel(context = context) as T
}