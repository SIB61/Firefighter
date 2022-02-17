package com.sibdev.firefighter.viewModels

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProfileScreenViewModel(context: Context):ViewModel() {
    val repository = Repository(Dispatchers.IO)
    val auth = Firebase.auth
    val document = Firebase.firestore.document("USERS/"+auth.uid)
    private  val _user: MutableStateFlow<User> = MutableStateFlow(User())
    val user: StateFlow<User> = _user

init {
    document.addSnapshotListener { value, error ->
        if(value != null)
        _user.value=value.toObject(User::class.java)!!
    }
}

}
class ProfileScreenViewModelProvider(val context: Context):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ProfileScreenViewModel(context = context) as T
}