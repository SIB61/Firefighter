package com.sibdev.firefighter.viewModels

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.PhoneNumberUtils
import android.telephony.SmsManager
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.ktx.Firebase
import com.sibdev.firefighter.db.Repository
import com.sibdev.firefighter.db.SharedPref
import com.sibdev.firefighter.models.AlarmModel
import com.sibdev.firefighter.models.Community


class AlarmScreenViewModel(val context: Context) : ViewModel() {
    val communities = mutableStateListOf<Community>(Community())
    var names = mutableStateListOf<String>("কমিউনিটি নির্বাচন করুন")
    var community = Community()
    val sharedPref = SharedPref(context = context)
 var info = ""
    init {
        Repository.MyCommunities.addSnapshotListener { v, e ->
            v?.documentChanges?.forEach {
                if (it.type == DocumentChange.Type.ADDED) {
                    communities.add(it.document.toObject(Community::class.java))
                    names.add(it.document.getString("name")!!)
                }
            }
        }
    }

    fun alart() {
        val msg = "sakj"
        if (verifyPhoneNumber(sharedPref.number1)) context.sendSMS(sharedPref.number1, msg)
        if (verifyPhoneNumber(sharedPref.number2)) context.sendSMS(sharedPref.number2, msg)
        if (verifyPhoneNumber(sharedPref.number3)) context.sendSMS(sharedPref.number3, msg)
        if (verifyPhoneNumber(sharedPref.number4)) context.sendSMS(sharedPref.number4, msg)
        if (verifyPhoneNumber(sharedPref.number5)) context.sendSMS(sharedPref.number5, msg)
        Repository.notifications(community.id)
            .add(AlarmModel(name = sharedPref.name, imageUrl = sharedPref.imageUrl, id = Firebase.auth.uid!!, info = info, communityName = community.name, communityId = community.id))
        callFireService()
    }

    private fun Context.sendSMS(phoneNumber: String, message: String) {
        val sentPI: PendingIntent = PendingIntent.getBroadcast(this, 0, Intent("SMS_SENT"), 0)
        SmsManager.getDefault().sendTextMessage("+88"+phoneNumber, null, message, sentPI, null)
    }

    private fun verifyPhoneNumber(number: String): Boolean =
        PhoneNumberUtils.isGlobalPhoneNumber("+88"+number)
    private fun callFireService(){
           val number : String = "16163"
           val callIntent = Intent(Intent.ACTION_CALL)
           callIntent.data = Uri.parse("tel:$number")
           context.startActivity(callIntent)
       }
}

class AlarmScreenViewModelProvider(val context: Context) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlarmScreenViewModel(context = context) as T
    }
}