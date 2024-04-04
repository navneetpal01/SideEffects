package com.example.sideeffects

import android.util.Log
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.filter

//TODO We can use snapshot flow sideEffect to convert from a state to kotlin flow why we need that ?
// cause as you know flow has multiple operators like map filter sometime you want to use them on a state

@Composable
fun LoggingTextInput() {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = {
            text = it
        }
    )
    val textFlow = snapshotFlow { text }
    LaunchedEffect(key1 = Unit) {
        textFlow
            .filter {
                it.length > 5
            }
            .collect {
                Log.d("test", "it")
            }
    }
}