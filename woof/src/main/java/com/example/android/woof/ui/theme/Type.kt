package com.example.android.woof.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.android.woof.R

private val AbrilFatface = FontFamily(Font(R.font.abril_fatface))

private val Montserrat = FontFamily(
    Font(R.font.montserrat),
    Font(R.font.montserrat_bold, FontWeight.Bold),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = AbrilFatface
    ),

    displayMedium = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Montserrat
    ),

    bodyLarge = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = Montserrat
    ),

    labelSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Montserrat
    ),
)
