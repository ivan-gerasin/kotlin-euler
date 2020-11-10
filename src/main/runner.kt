package main

val allIssue = listOf<Issue>(
    issues.Issue1(),
    issues.Issue2(),
    issues.Issue3(),
    issues.Issue4(),
    issues.Issue5()
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

