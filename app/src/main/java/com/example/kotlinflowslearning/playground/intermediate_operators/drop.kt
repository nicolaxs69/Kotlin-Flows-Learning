package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.flowOf

suspend fun main() {

    val flowDrop = flowOf(1, 10, 2, 3, 4)
        .drop(3)
        .collect { collectedValue ->
            println(collectedValue)
        }

    val flowDropWhile = flowOf(1, 10, 2, 3, 4)
        .dropWhile { it < 2 }
        .collect { collectedValue ->
            println(collectedValue)
        }
}