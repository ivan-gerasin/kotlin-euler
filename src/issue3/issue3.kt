package issue3

import main.Issue
import kotlin.concurrent.thread

class Issue3 : Issue {
/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
* */

    val primes = mutableMapOf<Long, Boolean>()

    private fun isPrime(num: Long): Boolean {
        if (primes.containsKey(num)) {
            return primes[num] as Boolean
        }
        return evalIsPrime(num)
    }

    private fun evalIsPrime(num: Long): Boolean {
        for (i in 2 .. Math.sqrt(num.toDouble()).toLong()) {
            val res = num % i == 0.toLong()
            if (res) {
                primes[num] = false
                return false
            }
        }
        primes[num] = true
        return true
    }

    fun searchForFactor(lowerEdge: Long, topEdge: Long, target: Long): Long? {
        var current = topEdge
        while (current > lowerEdge) {
            current--
            val leftOver = target%current
            if (leftOver == 0.toLong()) {
                if (isPrime(current)) {
                    return current
                }
            }
        }
        return null
    }

    override fun run() {
        val top = 600851475143
        val numberOfThreads = 8
        val chunkSize = top/numberOfThreads
        val portions = mutableListOf<Pair<Long, Long>>()

        for (i in 1 .. numberOfThreads) {
            portions.add(Pair((i-1)*chunkSize, chunkSize*i))
        }

        for (portion in portions) {
            thread {
                val result = searchForFactor(portion.first, portion.second, top)
                if (result!=null) {
                    println("Result of $portion")
                    println(result)
                }
            }
        }
    }
    //Result: 6857

    //TODO: this take too much time and timer don't works properly
}