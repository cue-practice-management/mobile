package com.example.cue_practice_management_mobile.core.events

import android.util.Log
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object EventBus {
    private val _events = MutableSharedFlow<Any>(extraBufferCapacity = 64)
    val events = _events.asSharedFlow()

    suspend fun send(event: Any) {
        Log.d("EventBus", "Sending event: ${event::class.java.simpleName}")
        _events.emit(event)
    }

    fun trySend(event: Any) {
        _events.tryEmit(event)
    }
}