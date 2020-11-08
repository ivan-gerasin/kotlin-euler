package main

interface Issue {
    fun run()
    fun print(str: String) {
        println(str)
    }
}