package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

suspend fun main() {

    val flowMap = flowOf(1, 2, 3, 4, 5)
        .map { "Map operators: ${it + 1}" }
        .collect { collectedValue ->
            println(collectedValue)
        }

    val flowMapNotNull = flowOf(1, 8, 3, 4, 5)
        .mapNotNull { "MapNotNull Operator: $it" }
        .collect { collectedValue ->
            println(collectedValue)
        }
}