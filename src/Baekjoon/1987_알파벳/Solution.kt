package Baekjoon.`1987_알파벳`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import java.util.*

class Solution {
    data class Point(
        val row: Int,
        val column: Int,
        val path: String
    )

    private val dirR = listOf(0, 0, 1, -1)
    private val dirC = listOf(1, -1, 0, 0)
    private var maxPath = -1

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))) {
        val st = StringTokenizer(readLine())
        val R = st.nextToken().toInt()
        val C = st.nextToken().toInt()
        val map = Array(R) { Array(C) { " " } }
        val cache = Array(R) { Array(C) { " " } }

        for (i in 0 until R) {
            map[i] = readLine().toCharArray().map{ it.toString() }.toTypedArray()
        }

        val needvisit = LinkedList<Point>()
        needvisit.add(Point(0, 0, map[0][0]))

        while (needvisit.isNotEmpty()) {
            val pair = needvisit.poll()
            maxPath = max(maxPath, pair.path.length)

            for (i in 0 until 4) {
                val newR = pair.row + dirR[i]
                val newC = pair.column + dirC[i]

                if (newR >= 0 && newR < R && newC >= 0 && newC < C && !pair.path.contains(map[newR][newC])) {
                    cache[newR][newC] = (pair.path + map[newR][newC])
                    needvisit.addLast(Point(newR, newC, pair.path + map[newR][newC]))
                }
            }
        }

        print(maxPath)
    }
}