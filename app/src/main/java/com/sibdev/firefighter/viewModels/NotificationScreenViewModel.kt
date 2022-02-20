package com.sibdev.firefighter.viewModels

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.Query
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.models.AlarmModel
import com.sibdev.firefighter.models.Community

class NotificationScreenViewModel(val context: Context):ViewModel() {
    val ids = mutableStateListOf<String>("")
    val notifications = mutableStateListOf(AlarmModel())

    init {
        Repository.MyCommunities.addSnapshotListener { v, e ->
            if (v != null) {
                for (dc in v.documentChanges)
                    if (dc.type == DocumentChange.Type.ADDED) {
                        val id = dc.document.toObject(Community::class.java).id
                        ids.add(id)
                        Repository.notifications(id).orderBy("timeStamp",Query.Direction.ASCENDING).addSnapshotListener { v1, e1 ->
                            if (v1 != null) {
                                for (dc1 in v1.documentChanges)
                                    if (dc1.type == DocumentChange.Type.ADDED) {
                                        notifications.add(dc1.document.toObject(AlarmModel::class.java))
                                    }
                            }
                        }
                    }
            }

        }
    }
}
class NotificationScreenViewModelProvider(val context: Context):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotificationScreenViewModel(context = context) as T
    }
}