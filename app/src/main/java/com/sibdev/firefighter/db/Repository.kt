package com.sibdev.firefighter.db

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object Repository {
    val Users=Firebase.firestore.collection("USERS")
    val Communities=Firebase.firestore.collection("COMMUNITIES")
    val MyCommunities= Users.document(Firebase.auth.uid!!).collection("MYCOMMUNITIES")
    fun requests(id:String) = MyCommunities.document(id).collection("REQUESTS")
    fun request(id:String)= Communities.document(id).collection("REQUESTS")
    fun userById(id:String):DocumentReference=Firebase.firestore.document("USERS/"+id)
    fun communityMembers(id:String):CollectionReference= Communities.document(id).collection("MEMBERS")
}

