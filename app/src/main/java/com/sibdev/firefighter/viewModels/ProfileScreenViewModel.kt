package com.sibdev.firefighter.viewModels

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.db.SharedPref
import com.sibdev.firefighter.models.Community
import com.sibdev.firefighter.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProfileScreenViewModel(context: Context):ViewModel() {
    val auth = Firebase.auth
    val document = Firebase.firestore.document("USERS/"+auth.uid)
    private  val _user: MutableStateFlow<User> = MutableStateFlow(User())
    val user: StateFlow<User> = _user
    val sharedPref = SharedPref(context = context)
    val s = mutableStateListOf<Community>()

init {
    _user.value= User(displayName = sharedPref.name, email = sharedPref.email, imageUrl = sharedPref.imageUrl)
    document.addSnapshotListener { value, error ->
        if(value != null)
        _user.value=value.toObject(User::class.java)!!
    }
    Repository.MyCommunities.addSnapshotListener{
        v , e ->
        v?.documentChanges?.forEach {
            if(it.type==DocumentChange.Type.ADDED)
            s.add(it.document.toObject(Community::class.java))

        }
    }
}

}
class ProfileScreenViewModelProvider(val context: Context):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = ProfileScreenViewModel(context = context) as T
}