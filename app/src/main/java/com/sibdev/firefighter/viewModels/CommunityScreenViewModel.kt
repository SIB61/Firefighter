package com.sibdev.firefighter.viewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.DocumentChange
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.db.SharedPref
import com.sibdev.firefighter.models.Community
import com.sibdev.firefighter.models.Request

class CommunityScreenViewModel(context: Context):ViewModel() {
    val sharedPref = SharedPref(context = context)
    var community by  mutableStateOf(Community())
    var members = mutableStateListOf(Request())
    init {
        Repository.communityById(sharedPref.community).addSnapshotListener{
                v,e->
                community = v?.toObject(Community::class.java)!!
                Toast.makeText(context,community.toString(),Toast.LENGTH_SHORT).show()
        }
        Repository.membersOfCommunity(sharedPref.community).addSnapshotListener{
                v,e->
            v?.documentChanges?.forEach {
                if(it.type== DocumentChange.Type.ADDED)
                    members.add(it.document.toObject(Request::class.java))
            }
        }
    }
}
class CommunityScreenViewModelProvider(val context: Context):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommunityScreenViewModel(context = context) as T
    }
}
