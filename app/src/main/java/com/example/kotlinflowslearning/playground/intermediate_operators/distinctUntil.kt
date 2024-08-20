package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOf

suspend fun main() {
    val flowDistinctUntilChanged = flowOf(1, 1, 8, 8, 2, 3, 4)
        .distinctUntilChanged()
        .collect { collectedValue ->
            println(collectedValue)
        }
}