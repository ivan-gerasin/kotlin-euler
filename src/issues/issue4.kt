package issues

import main.Issue

class Issue4: Issue {

    /*
        A palindromic number reads the same both ways.
        The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
        Find the largest palindrome made from the product of two 3-digit numbers.
    * */

    fun isPalindrome(num: Int): Boolean {
        val str = num.toString()
        return str.reversed() == str
    }

    override fun run() {
        val top = 999
        val bottom = 100
        val pals = mutableListOf<Int>()
        for (first in top downTo bottom) {
            for (second in top downTo bottom) {
                val product = first*second
                if(isPalindrome(product)) {
                    pals.add(product)
                }
            }
        }
        println(pals.max())
    }
}