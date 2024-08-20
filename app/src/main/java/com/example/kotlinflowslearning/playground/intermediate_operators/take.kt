package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.takeWhile

suspend fun main() {

    val flowTake = flowOf(1, 10, 2, 3, 4)
        .take(3)
        .collect { collectedValue ->
            println(collectedValue)
        }

    val flowTakeWhile = flowOf(1, 2, 3, 4, 10)
        .takeWhile { it < 4 }
        .collect { collectedValue ->
            println(collectedValue)
        }
}