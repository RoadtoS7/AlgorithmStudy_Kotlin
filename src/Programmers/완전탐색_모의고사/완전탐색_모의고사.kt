package Programmers

import java.util.Collections.max

class Solution {
    fun solution(answers: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val giveups = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(2, 1, 2, 3, 2, 4, 2, 5),
            listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )
        val scores = mutableListOf(0, 0, 0)

        answers.forEachIndexed { i, answer ->
            giveups.forEachIndexed { j, giveup ->
                if (giveup[i % giveup.size] == answer) {
                    scores[j] += 1
                }
            }
        }

        val max_score = max(scores)
        scores.forEachIndexed { index, score ->
            if (score == max_score) {
                answer.add(index + 1)
            }
        }
        return answer.toIntArray()
    }
}



