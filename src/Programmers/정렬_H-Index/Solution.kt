package Programmers.`정렬_H-Index`

class Solution {
    fun solution(citations: IntArray): Int {
        val maxCount = citations.max()!!
        var count = maxCount.plus(1)
        var bookCount = 0
        while (bookCount < count){
            count = count.minus(1)
            bookCount = 0
            for (citation in citations) {
                if (citation >= count!!) {
                    bookCount += 1
                }
            }
        }
        return count
    }
}