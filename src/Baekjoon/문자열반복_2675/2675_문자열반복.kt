package Baekjoon

class Solution {
    fun solve() {
        val T = readLine()!!.toInt()
        for (i in 1..T) {
            val input = readLine()!!.split(" ")
            val count = input[0].toInt()
            val str = input[1].toList()

            val result = mutableListOf<Char>()
            str.forEach {
                for (index in 1..count) {
                    result.add(it)
                }
            }
            print(result.joinToString(""))

        }
    }
}