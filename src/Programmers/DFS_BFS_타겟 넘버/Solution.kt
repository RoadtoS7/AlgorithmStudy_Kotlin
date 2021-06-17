package Programmers.`DFS_BFS_타겟 넘버`

import java.util.*

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        val n = numbers.size
        val needVisit: Queue<List<Int>> = LinkedList<List<Int>>()
        needVisit.add(listOf(numbers[0], 0))
        needVisit.add(listOf(-numbers[0], 0))

        while (needVisit.isNotEmpty()) {
            val node = needVisit.remove()

            var result = node[0] + numbers[node[1] + 1]
            if (node[1] + 1 == n - 1 && result == target) answer += 1
            if (node[1] + 2 < n) needVisit.add(listOf(result, node[1] + 1))

            result = node[0] - numbers[node[1] + 1]
            if (node[1] + 1 == n - 1 && result == target) answer += 1
            if (node[1] + 2 < n) needVisit.add(listOf(result, node[1] + 1))
        }
        return answer
    }
}