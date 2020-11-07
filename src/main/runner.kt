package main

import euler.Issue
import issue1.Issue1
import issue2.Issue2
import java.io.IOException
import java.time.LocalDate
import java.util.concurrent.TimeUnit

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
            val startTime = System.currentTimeMillis()
            issues[issueNumber - 1].run()
            val endTime = System.currentTimeMillis()
            val resultTime = endTime-startTime
        } catch (e: NumberFormatException) {
            println("Invalid value - should be a number")
        } catch (e: IndexOutOfBoundsException) {
            println("No such issue")
        }
    }
}

fun getCommitHash(): String? {
    try {
        val proc = ProcessBuilder("git", "rev-parse", "HEAD").start()
        proc.waitFor(60, TimeUnit.MINUTES)
        return proc.inputStream.bufferedReader().readText()
    } catch(e: IOException) {
        e.printStackTrace()
        return null
    }
}
