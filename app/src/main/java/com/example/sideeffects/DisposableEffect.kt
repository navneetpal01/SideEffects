package com.example.sideeffects

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver

@Composable
fun DisposableEffectExample(
    onCreate: (() -> Unit)? = null,
    onStart: (() -> Unit)? = null,
    onResume: (() -> Unit)? = null,
    onPause : (() -> Unit)? = null,
    onStop: (() -> Unit)? = null,
    onDestroy: (() -> Unit)? = null,
    onAny: (() -> Unit)? = null,
) {
    val lifeCycleOwner = LocalLifecycleOwner.current
    //used for adding and cleaning up the observer
    DisposableEffect(
        key1 = lifeCycleOwner,
        effect = {
            val lifecycleObserver = LifecycleEventObserver{ _,Event ->
                when(Event){
                    Lifecycle.Event.ON_CREATE -> onCreate?.invoke()
                    Lifecycle.Event.ON_START -> onStart?.invoke()
                    Lifecycle.Event.ON_RESUME -> onResume?.invoke()
                    Lifecycle.Event.ON_PAUSE -> onPause?.invoke()
                    Lifecycle.Event.ON_STOP -> onStop?.invoke()
                    Lifecycle.Event.ON_DESTROY -> onDestroy?.invoke()
                    Lifecycle.Event.ON_ANY -> onAny?.invoke()
                }

            }
            lifeCycleOwner.lifecycle.addObserver(lifecycleObserver)
            onDispose {
                lifeCycleOwner.lifecycle.removeObserver(lifecycleObserver)
            }
        }
    )
}