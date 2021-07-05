package Programmers

class DFS_BFS_네트워크 {

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val graph = Array(n) { mutableListOf<Int>() }
        val visited = Array(n) { false }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i != j && computers[i][j] == 1) {
                    graph[i].add(j)
                }
            }
        }

        for (i in 0 until n) {
            if (bfs(visited, n, i, graph)) {
                answer += 1
            }
        }

        return answer
    }

    fun bfs(visited: Array<Boolean>, n: Int, start: Int, graph: Array<MutableList<Int>>): Boolean {
        val needVisit = mutableListOf(start)
        var isNetworkExist = false
        while (needVisit.isNotEmpty()) {
            val node = needVisit.removeAt(0)
            if (!visited[node]) {
                visited[node] = true
                isNetworkExist = true
                for (adj in graph[node]) {
                    if (!visited[adj]) needVisit.add(adj)
                }
            }
        }
        return isNetworkExist
    }
}