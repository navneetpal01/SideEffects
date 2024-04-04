package com.example.sideeffects

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun TimeOutWith2Button(){
    Column {
        var clickedButtonColor by remember { mutableStateOf("Unknown") }
        Button(
            onClick = {
                clickedButtonColor = "Red"
            },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Red)
        ) {
            Text(text = "Red Button")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                clickedButtonColor = "Black"
            },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Black)
        ) {
            Text(text = "Black Button")
        }
        TimeOut(buttonColor = clickedButtonColor)
    }
}

@Composable
fun TimeOut(
    buttonColor : String
){
    Log.d("test", "Composing Timer with the color : $buttonColor")

    val buttonColorUpdated by rememberUpdatedState(newValue = buttonColor)

    //Passing null cause Launched Effect will run only one Time
    LaunchedEffect(key1 = null) {
        delay(10000)
        Log.d("test", "Timeout ended")
        Log.d("test", "Last pressed button Color : $buttonColorUpdated")

    }
}