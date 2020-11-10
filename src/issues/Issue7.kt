package issues

import main.Issue

class Issue7: Issue {

    private fun evalIsPrime(num: Long): Boolean {
        for (i in 3 .. Math.sqrt(num.toDouble()).toLong() step 2) {
            val res = num % i == 0.toLong()
            if (res) {
                return false
            }
        }
        return true
    }

    override fun run() {
        val target = 10_001
        var num = 0
        var counter = 1

        while (num!=target-1) {
            counter+=2
            if (evalIsPrime(counter.toLong())) {
                num++
            }
        }
        println(counter)
    }
}