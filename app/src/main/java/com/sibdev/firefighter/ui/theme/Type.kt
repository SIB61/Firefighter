package com.sibdev.firefighter.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sibdev.firefighter.R

// Set of Material typography styles to start with
val fonts = FontFamily(
    Font(R.font.font_regular),
    Font(R.font.font_bold, weight = FontWeight.Bold),
    Font(R.font.font_light, weight = FontWeight.Light),
    Font(R.font.font_medium, weight = FontWeight.Medium),
    Font(R.font.font_semibold, weight = FontWeight.SemiBold)
)


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)