package timingResults

import java.io.File
import java.lang.Exception

typealias ResultRecordFormatter = (results: ResultRecord) -> String

val csvFormatter: (ResultRecord) -> String = fun(results: ResultRecord): String {
    return listOf(results.date, results.hash, results.time).joinToString(",")
}

class ResultsWriter(private val result: ResultRecord, private val dir: String, private val fileName: String = "results.csv") {
    val basePath: String = "/home/igerasin/projects/euler/src"
    val fileExtention: String = ".csv"
    val formatter: ResultRecordFormatter = csvFormatter

    private fun getPath(): String {
        return listOf(basePath, dir, fileName).joinToString("/")
    }

    fun getFormattedResult(): String {
        return formatter(result)+'\n'
    }

    fun save() {
        try {
            File(getPath()).appendText(getFormattedResult())
        } catch (e : Exception) {
            println(e)
        }

    }
}