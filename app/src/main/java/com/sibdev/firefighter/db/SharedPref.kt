package com.sibdev.firefighter.db

import android.content.Context
import android.content.SharedPreferences

class SharedPref(val context: Context) {
    val instance = context.getSharedPreferences("SharedPref",0)
    val email: String=instance.getString("email","")!!
    val name: String=instance.getString("name","")!!
    val imageUrl:String=instance.getString("imageUrl","")!!
    val number1:String=instance.getString("number1","")!!
    val number2: String=instance.getString("number2","")!!
    val number3:String=instance.getString("number3","")!!
    val number4:String=instance.getString("number4","")!!
    val number5:String=instance.getString("number5","")!!

    fun setEmail(email:String)=instance.edit().putString("email",email).commit()
    fun setName(name:String)=instance.edit().putString("name",name).commit()
    fun setImageUrl(url:String)=instance.edit().putString("imageUrl",url).commit()
    fun setNumber1(n:String)=instance.edit().putString("number1",n).commit()
    fun setNumber2(n:String)=instance.edit().putString("number2",n).commit()
    fun setNumber3(n:String)=instance.edit().putString("number3",n).commit()
    fun setNumber4(n:String)=instance.edit().putString("number4",n).commit()
    fun setNumber5(n:String)=instance.edit().putString("number5",n).commit()

}