package Baekjoon.`1874_스택 수열`

import java.util.*
import kotlin.system.exitProcess

class Solution {
    fun solution() {
        val n = readLine()!!.toInt()
        var count = 1
        val stack = Stack<Int>()
        val result = mutableListOf<String>()

        repeat(n) {
            val data = readLine()!!.toInt()
            while (count <= data) {
                stack.push(count)
                count += 1
                result.add("+")
            }

            if (stack.lastElement() == data) {
                stack.pop()
                result.add("-")
            } else {
                println("NO")
                exitProcess(0)
            }
        }

        result.forEach { println(it) }
    }
}