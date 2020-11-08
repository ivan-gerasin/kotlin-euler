package issue1

import main.Issue

class Issue1 : Issue {

    override fun run() {
        /*
        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
        The sum of these multiples is 23.
        Find the sum of all the multiples of 3 or 5 below 1000.
        */
        val top = 1000
        var accumulator = 0
        for (i in 1 until top) {
            if (i % 3 == 0 || i % 5 == 0) {
                accumulator += i
            }
        }
        //TimingResult: 233168
        println(accumulator)
    }
}