package leetcode.problem_231

fun main() {
    isPowerOfTwo(8)
}

fun isPowerOfTwo(n: Int): Boolean {
    val ones = n.countOneBits()
    
    return n > 1 && ones == 1
}