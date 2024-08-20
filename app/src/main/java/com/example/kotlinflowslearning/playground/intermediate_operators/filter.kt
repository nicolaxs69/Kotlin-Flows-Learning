package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOf

suspend fun main() {

    val flowFilter = flowOf(1, 2, 3, 4, 5)
        .filter { it > 7 }
        .collect { collectedValue ->
            println(collectedValue)
        }

    val flowFilterNotNull = flowOf(1, null, 2, 3, 4)
        .filterNotNull()
        .collect { colllectedValue ->
            println(colllectedValue)
        }

    val flowFiterIsInstance = flowOf(1, "Hello World", 2, 3, 4)
        .filterIsInstance<String>()
        .collect { collectedValue ->
            println(collectedValue)
        }
}