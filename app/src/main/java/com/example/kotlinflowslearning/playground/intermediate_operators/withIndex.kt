package com.example.kotlinflowslearning.playground.intermediate_operators

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.withIndex

suspend fun main() {

    val flowWithIndex = flowOf(1, 2, 3, 4, 5, 1)
        .withIndex()
        .collect { collectedValue ->
            println(collectedValue)
        }
}