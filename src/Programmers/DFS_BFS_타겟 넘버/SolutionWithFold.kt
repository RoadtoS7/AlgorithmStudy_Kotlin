package Programmers.`DFS_BFS_타겟 넘버`

class SolutionWithFold {
    fun solution(numbers: IntArray, target: Int): Int {
        return numbers.fold(listOf(0)) { acc, i ->
            acc.run { map { it + i } + map { it - i } }
        }.count { it == target }

    }
}