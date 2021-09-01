package Baekjoon.`2920_음계`

class Solution {

    fun solution() {
        var ascending = true
        var descending = true

        val input = readLine()!!.split(" ").map { it.toInt() }

        IntRange(0, input.size - 2).forEach {
            if (input[it] > input[it + 1]) {
                ascending = false
            } else {
                descending = false
            }
        }

        if (ascending) {
            print("ascending")
            return
        }
        if (descending) {
            print("descending")
            return
        }
        print("mixed")
        return
    }

}