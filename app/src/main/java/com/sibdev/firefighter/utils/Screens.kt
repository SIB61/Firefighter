package com.sibdev.firefighter.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.sibdev.firefighter.R

sealed class Screens(val route:String, val icon:Int, val title:String){
    object Home:Screens(route = "home",icon = R.drawable.ic_baseline_home_24,title = "হোম")
    object Profile:Screens(route = "person", icon = R.drawable.ic_baseline_person_24, title = "প্রোফাইল")
    object Settings:Screens(route = "settings", icon = R.drawable.ic_baseline_settings_24, title = "সেটিংস")
    object Alarm:Screens(route = "alarm", icon = R.drawable.ic_baseline_add_alarm_24, title = "বিপদ সংকেত")
    object Precautions:Screens(route = "preventions",icon = R.drawable.ic_baseline_published_with_changes_24,title = "অগ্নি প্রতিরোধ")
    object UrgentSteps:Screens(route = "urgent_steps",icon=R.drawable.ic_baseline_format_list_numbered_24,title = "অগ্নি নির্বাপণ")
   object Logout:Screens(route = "log_out", icon = R.drawable.ic_baseline_logout_24, title = "LOG OUT")
}
