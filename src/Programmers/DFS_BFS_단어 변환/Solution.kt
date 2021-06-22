package Programmers.`DFS_BFS_단어 변환`

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0
        val words = words.toMutableList()
            .apply { add(begin) }

        val graph = HashMap<String, MutableList<String>>()

        words.forEach { graph[it] = mutableListOf() }
        for (i in words.indices) {
            for (j in i until words.size) {
                var count = 0
                for (k in words[i].indices) {
                    if (words[i][k] != words[j][k]) {
                        count += 1
                    }
                }

                if (count == 1) {
                    graph[words[i]]?.add(words[j])
                    graph[words[j]]?.add(words[i])
                }
            }
        }

        answer = bfs(begin, target, graph)

        return answer
    }

    private fun bfs(begin: String, target: String, graph: HashMap<String, MutableList<String>>): Int {
        var minCount = 51
        val needVisit: Queue<Pair<String, HashSet<String>>> = LinkedList<Pair<String, HashSet<String>>>()

        needVisit.add(begin to HashSet())
        while (needVisit.isNotEmpty()) {
            val node = needVisit.remove()
            if (node.first == target) {
                minCount = min(minCount, node.second.size)
            }

            for (adj in graph[node.first]!!) {
                if (adj !in node.second) {
                    val newPath = node.second.clone() as HashSet<String>
                    newPath.add(adj)
                    needVisit.add(adj to newPath)
                }
            }
        }

        return if (minCount == 51) {
            0
        } else {
            minCount
        }
    }
}