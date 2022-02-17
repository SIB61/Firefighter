package com.sibdev.firefighter.db

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow


class Repository(val ioDispacher:CoroutineDispatcher){
    val repository = Firebase.firestore
    val USERS = repository.collection("USERS")


    suspend fun getUsersFromFirestore(): List<User> = USERS.get().result.toObjects(User::class.java)
    suspend fun addUserToFirestore(user:User){ USERS.document(user.uId).set(user) }
}