package com.example.kotlinflowslearning.playground.basics

import com.example.kotlinflowslearning.playground.printWithTimePassed
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.math.BigInteger


// This is an example of the flow builder function.

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    launch {
        calculateFactorialOf(5).collect { collectedValue ->
            printWithTimePassed(collectedValue, startTime)
        }
    }
    println("Ready for more work")
}

private fun calculateFactorialOf(number: Int): Flow<BigInteger> = flow {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        delay(10)
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        emit(factorial)
    }
}.flowOn(Dispatchers.Default)