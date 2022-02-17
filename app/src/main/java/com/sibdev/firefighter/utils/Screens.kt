package com.sibdev.firefighter.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.sibdev.firefighter.R

sealed class Screens(val route:String, val icon:Int, val title:String){
    object Home:Screens(route = "home",icon = R.drawable.ic_baseline_home_24,title = "HOME")
    object Profile:Screens(route = "person", icon = R.drawable.ic_baseline_person_24, title = "PROFILE")
    object Settings:Screens(route = "settings", icon = R.drawable.ic_baseline_settings_24, title = "SETTINGS")

    object Alarm:Screens(route = "alarm", icon = R.drawable.ic_baseline_add_alarm_24, title = "ALARM")
    object Precautions:Screens(route = "preventions",icon = R.drawable.ic_baseline_published_with_changes_24,title = "PRECAUTIONS")
    object UrgentSteps:Screens(route = "urgent_steps",icon=R.drawable.ic_baseline_format_list_numbered_24,title = "URGENT STEPS")

   object Logout:Screens(route = "log_out", icon = R.drawable.ic_baseline_logout_24, title = "LOG OUT")
}
