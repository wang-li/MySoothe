package com.example.mysoothe.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.mysoothe.R

val KulimPark = FontFamily(
    Font(R.font.kulimpark_regular),
    Font(R.font.kulimpark_light, FontWeight.Light)
)

val Lato = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = KulimPark,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp,
        letterSpacing = 1.15.sp
    ),
    h2 = TextStyle(
        fontFamily = KulimPark,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = 1.15.sp
    ),
    h3 = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    body1 = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 1.15.sp
    ),
    caption = TextStyle(
        fontFamily = KulimPark,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 1.15.sp
    )
)