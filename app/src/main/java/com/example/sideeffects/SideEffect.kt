package com.example.sideeffects

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
fun SystemBarColorChange(
    statusBarColor: Color?,
    navigationBarColor: Color?
) {
    val window = (LocalContext.current as Activity).window


    //When you want to change non compose state inside a composable function

    SideEffect {
        statusBarColor?.let {
            window.statusBarColor = it.toArgb()
        }

        navigationBarColor?.let {
            window.navigationBarColor = it.toArgb()
        }
    }

}