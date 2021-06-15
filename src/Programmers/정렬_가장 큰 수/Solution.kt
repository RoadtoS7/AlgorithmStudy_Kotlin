package Programmers.`정렬_가장 큰 수`

class Solution {
    fun solution(numbers: IntArray): String {
        val stringNumbers = numbers.map { it.toString() }
        val result = stringNumbers.sortedWith { o1, o2 ->
            (o2 + o1).compareTo(o1 + o2)
        }

        if (result[0] == "0") {
            return "0"
        }

        return result.reduce { acc, s -> "$acc$s" }
    }
}
