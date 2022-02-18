package com.sibdev.firefighter.viewModels

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.models.Numbers
import com.sibdev.firefighter.models.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EmergencyNumberScreenViewModel : ViewModel(){
    val auth = Firebase.auth
    private val documentReference=Repository.userById(auth.uid!!)
    val back = mutableStateOf(false)
    fun saveEmergencyNumbers(numbers: Numbers){
           documentReference.get().addOnCompleteListener{
               if(it.isSuccessful){
                   val user = it.result.toObject(User::class.java)!!.copy(
                       number1 = numbers.number1,
                       number2 = numbers.number2,
                       number3 = numbers.number3,
                       number4 = numbers.number4,
                       number5 = numbers.number5
                   )
                   documentReference.set(user).addOnCompleteListener{
                       back.value=true
                   }
               }
           }
    }
}
class EmergencyNumberScreenViewModelProvider : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EmergencyNumberScreenViewModel() as T
    }
}