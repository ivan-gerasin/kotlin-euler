package main

import issue1.Issue1
import issue2.Issue2
import timingResults.ResultsWriter
import timingResults.TimingResult

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
            val startTime = System.nanoTime()
            issues[issueNumber - 1].run()
            val endTime = System.nanoTime()
            println(endTime-startTime)
            println("Elapsed time: ${endTime-startTime}")
            val record = TimingResult(endTime-startTime).getRecord()
            ResultsWriter(record, "issue$issueNumber").save()

        } catch (e: NumberFormatException) {
            println("Invalid value - should be a number")
        } catch (e: IndexOutOfBoundsException) {
            println("No such issue")
        }
    }
}

