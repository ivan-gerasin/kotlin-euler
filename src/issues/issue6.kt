package issues

import main.Issue

class Issue6: Issue {

/*

Find the difference between the sum of the squares of the first one hundred
natural numbers and the square of the sum.
* */

    fun sumOfSquares(numberOfNums: Int): Int {
        return (1..numberOfNums).map { it*it }.sum()
    }

    fun squareOfSum(numberOfNums: Int): Int {
        return Math.pow((1..numberOfNums).sum().toDouble(), 2.toDouble()).toInt()
    }

    override fun run() {
        println(squareOfSum(100)-sumOfSquares(100))
        //result 25164150
    }
}