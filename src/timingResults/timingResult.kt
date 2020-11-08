package timingResults

import java.io.IOException
import java.time.LocalDate
import java.util.concurrent.TimeUnit

data class ResultRecord(val date: String, val hash: String, val time: String)

class TimingResult(private val result: Long) {

    fun getRecord(): ResultRecord {
        val hash = getCommitHash() ?: throw Exception("Can not get commit hash")
        return ResultRecord(getDate(), hash, result.toString())
    }

    private fun getDate(): String {
        return LocalDate.now().toString()
    }

    private fun getCommitHash(): String? {
        try {
            val proc = ProcessBuilder("git", "rev-parse", "HEAD").start()
            proc.waitFor(60, TimeUnit.MINUTES)
            return proc.inputStream.bufferedReader().readText().trim()
        } catch(e: IOException) {
            e.printStackTrace()
            return null
        }
    }

}