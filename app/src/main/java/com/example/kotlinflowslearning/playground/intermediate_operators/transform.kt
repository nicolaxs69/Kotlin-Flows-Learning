package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.transform


suspend fun main() {

    // The big difference between map and transform is that transform allows you to emit multiple values

    val flowTransform = flowOf(1, 8, 2, 3, 4)
        .transform {
            emit(it)
            emit(it * 10)
        }
        .collect { collectedValue ->
            println(collectedValue)
        }
}