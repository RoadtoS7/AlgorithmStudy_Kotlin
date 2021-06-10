package Baekjoon.`2839_설탕 배달`

class Solution {
    fun solve() {
        val N = readLine()!!.toInt()
        var m = N / 5

        if (N < 5 && N % 3 != 0) {
            println(-1)
            return
        }

        while (true) {
            val num = N - 5 * m

            if (m == 0 && num % 3 != 0) {
                println(-1)
                break
            }

            if (num % 3 == 0) {
                println(num / 3 + m)
                break
            }
            m -= 1
        }
    }
}