package com.example.sideeffects

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RememberCoroutineScopeExample() {
    val names = remember {
        //map returns list of transformed object can only be used with collections like lists etc
        (0..100).map { "Name $it" }
    }

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    scrollState.animateScrollTo(scrollState.maxValue)
                }
                //Composable function should be called only from other composable functions
                //and we are calling it here in the callback
//               LaunchedEffect(key1 = Unit,){
//
//               }
            }
            ) {
                Icon(
                    imageVector = Icons.Rounded.ArrowDropDown,
                    contentDescription = null
                )
            }

        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            names.forEach { name ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    text = name,
                )
            }
        }
    }
}