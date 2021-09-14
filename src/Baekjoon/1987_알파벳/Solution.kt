package Baekjoon.`1987_알파벳`

import java.lang.Integer.max

class Solution {

    fun solution() {
        val inputs = readLine()!!.split(" ").map { it.toInt() }
        val R = inputs[0]
        val C = inputs[1]
        val direction = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
        var maxPath = -1

        val map = IntRange(1, R).map { readLine()!!.toList() }

        fun dfs(map: List<List<Char>>, r: Int, c: Int, path: Set<Char>) {
            maxPath = max(maxPath, path.size)

            for (dir in direction){
                val newR = r + dir.first
                val newC = c + dir.second

                if (newR >= 0 && newR < R && newC >= 0 && newC < C && map[newR][newC] !in  path) {
                    dfs(map, newR, newC, path.toMutableSet().apply { add(map[newR][newC]) })
                }
            }
        }

        dfs(map, 0, 0, mutableSetOf(map[0][0]))
        print(maxPath)
    }
}