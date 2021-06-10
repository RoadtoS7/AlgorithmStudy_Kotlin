package Baekjoon

class SolutionRepeat {
    fun solve() {
        val T = readLine()!!.toInt()

        repeat(T) {
            val (re: String, str: String) = readLine()!!.split(" ")
            var result = ""

            for (char in str){
                repeat(re.toInt()){
                    result += char
                }
            }
            println(result)
        }
    }
}