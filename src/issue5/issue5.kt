package issue5

import main.Issue

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
* */

class Issue5 : Issue {

    fun noReminder(num: Int): Boolean {
        for (i in 20 downTo 2) {
            if (num%i!=0) {
                return false
            }
        }
        return true
    }

    override fun run() {
        var i = 2520
        var num: Int? = null
        while (num==null) {
            i++
            if (noReminder(i)) {
                num = i as Int
            }
        }
        println(num)
        //result 232792560
    }
}