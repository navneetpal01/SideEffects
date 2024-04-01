package com.example.sideeffects

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LaunchedEffectExampleFirst(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        val text = remember { mutableStateOf("") }
        val text2 = remember { mutableStateOf("") }

        //A simple Launched Effect
        LaunchedEffect(key1 = text){
            delay(200)
        }
        //Can pass multiple keys
        LaunchedEffect(key1 = text,key2 = text2){
            delay(200)
        }
        //Can have multiple chile coroutines
        LaunchedEffect(key1 = text,key2 = text2){
            delay(200)
            launch {

            }
            launch {

            }
        }
    }
}

@Composable
fun LaunchedEffectExampleSecond(
    max : Int,
    onCountChange : (Int) -> Unit
){
    var counter by remember { mutableIntStateOf(0) }

    // return@LaunchedEffect terminates the execution of Launched Effect if condition is fulfilled
    LaunchedEffect(key1 = counter){

//        if (counter >= max + 1){
//            return@LaunchedEffect
//        }
//        delay(1000)
//        onCountChange(counter)
//        counter++

        for (i in 0..max){
            delay(1000)
            onCountChange(counter)
            counter++
        }

    }
}