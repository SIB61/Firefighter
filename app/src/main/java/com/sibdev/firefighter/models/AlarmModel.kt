package com.sibdev.firefighter.models

import com.google.firebase.Timestamp

data class AlarmModel(
    val name : String ="",
    val id : String = "",
    val communityId: String="",
    val communityName: String="",
    val timeStamp:Timestamp= Timestamp.now(),
    val location:String = "",
    val info:String="",
    val imageUrl : String = "",
)