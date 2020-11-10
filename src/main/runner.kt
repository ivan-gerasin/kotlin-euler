package main

import issues.*

val allIssue = listOf<Issue>(
    Issue1(),
    Issue2(),
    Issue3(),
    Issue4(),
    Issue5(),
    Issue6(),
    Issue7(),
    Issue8()
)
fun main() {
    print("Enter number of issue: ")
    val issueNumberAsStr = readLine()
    if (issueNumberAsStr != null) {
        try {
            val issueNumber = issueNumberAsStr.toInt()
//            val startTime = System.nanoTime()
            allIssue[issueNumber - 1].run()
//            val endTime = System.nanoTime()
//            println("Elapsed time: ${endTime-startTime}ns")
//            val record = TimingResult(endTime-startTime).getRecord()
//            ResultsWriter(record, "issue$issueNumber").save()

        } catch (e: NumberFormatException) {
            println("Invalid value - should be a number")
        } catch (e: IndexOutOfBoundsException) {
            println("No such issue")
        }
    }
}

