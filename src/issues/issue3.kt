package issues

import main.Issue

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
        for (i in 3 .. Math.sqrt(num.toDouble()).toLong() step 2) {
            val res = num % i == 0.toLong()
            if (res) {
                primes[num] = false
                return false
            }
        }
        primes[num] = true
        return true
    }

    fun searchForFactor(target: Long): Long? {
        var current = 1L
        var largestPrime = 1L
        val targetSqrt = Math.sqrt(target.toDouble()).toLong()
        while (current < targetSqrt) {
            current += 2
            val leftOver = target%current
            if (leftOver == 0.toLong()) {
                if (isPrime(current)) {
                    largestPrime = current
                }
            }
        }
        return largestPrime
    }

    override fun run() {
        val top = 600851475143
        val res = searchForFactor(top)
        println(res)
        //Result: 6857
    }
}