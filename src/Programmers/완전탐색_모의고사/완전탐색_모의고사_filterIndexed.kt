package Programmers

class FilterIndexed {
    fun solution(answers: IntArray): IntArray {
        val studentA = listOf(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
        val studentB = listOf(2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5)
        val studentC = listOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val scores = listOf(
            Pair(1, answers.filterIndexed { index, answer -> studentA[index % studentA.size] == answer }.count()),
            Pair(2, answers.filterIndexed { index, answer -> studentB[index % studentB.size] == answer }.count()),
            Pair(3, answers.filterIndexed { index, answer -> studentC[index % studentC.size] == answer }.count())
        ).sortedByDescending { it.second }


        return when {
            scores[0].second == scores[1].second && scores[1].second == scores[2].second -> intArrayOf(
                scores[0].first,
                scores[1].first,
                scores[2].first
            )
            scores[0].second == scores[1].second -> intArrayOf(scores[0].first, scores[1].first)
            else -> intArrayOf(scores[0].first)
        }
    }
}