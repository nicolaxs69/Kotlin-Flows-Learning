package com.example.kotlinflowslearning.playground.basics

import com.example.kotlinflowslearning.playground.printWithTimePassed
import java.math.BigInteger

private fun main() {

    val startTime = System.currentTimeMillis()

    calculateFactorialOf(5).forEach {
        printWithTimePassed(it, startTime)
    }
    println("Ready for more work")
}

private fun calculateFactorialOf(number: Int): Sequence<BigInteger> = sequence {
    var factorial = BigInteger.ONE
    for (i in 1..number) {
        Thread.sleep(10)
        println("Time elapsed")
        factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        yield(factorial)
    }
}

