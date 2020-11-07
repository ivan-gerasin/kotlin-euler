package main

import euler.Issue
import issue1_multiples_of_3_and_5.Issue1
import issue2_even_fib_numbers.Issue2

val issues = listOf<Issue>(
    Issue1(),
    Issue2()
)
fun main() {
    print("Enter number of issue: ")
    val issueNumberAsStr = readLine()
    if (issueNumberAsStr != null) {
        try {
            val issueNumber = issueNumberAsStr.toInt()
            issues[issueNumber - 1].run()
        } catch (e: NumberFormatException) {
            println("Invalid value - should be a number")
        } catch (e: IndexOutOfBoundsException) {
            println("No such issue")
        }
    }
}