package com.example.kotlinflowslearning.playground.terminal_operators

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

fun main() {

    val flow = flow {
        delay(100)

        println("Emitting first value")
        emit(1)

        delay(100)

        println("Emitting second value")
        emit(2)
    }

    val scope = CoroutineScope(EmptyCoroutineContext)

    // launchIn: Launches the collection of the flow in a separate coroutine
    flow
        .onEach { println("Received $it with launchIn() - 1 at ${System.currentTimeMillis()}") }
        .launchIn(scope)

    flow
        .onEach { println("Received $it with launchIn() - 2 at ${System.currentTimeMillis()}") }
        .launchIn(scope)

    // Collect: Collects the flow in the current coroutine
    scope.launch {
        // Collect suspend its coroutine until the flow completes, only then can the coroutine resume and start collection on the next flow
        flow.collect {
            println("Received $it in collect - 1at ${System.currentTimeMillis()}")
        }

        flow.collect {
            println("Received $it in collect - 2 at ${System.currentTimeMillis()}")
        }
    }

    Thread.sleep(1000)
}