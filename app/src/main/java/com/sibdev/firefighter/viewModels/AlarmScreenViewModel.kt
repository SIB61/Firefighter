package com.sibdev.firefighter.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AlarmScreenViewModel (val context: Context):ViewModel(){

}
class AlarmScreenViewModelProvider(val context: Context):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlarmScreenViewModel(context = context) as T
    }
}