package com.example.sideeffects

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay


@Composable
fun Counter() {
    val state = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        for (i in 1..10) {
            delay(1000)
            state.value += 1
        }
    }
    Text(
        modifier = Modifier,
        text = state.value.toString(),
        style = MaterialTheme.typography.headlineMedium
    )
}

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun CounterProduceState() {
    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(1000)
            value += 1
        }
    }
}

