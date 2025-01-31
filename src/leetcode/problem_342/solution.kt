package leetcode.problem_342

import leetcode.problem_231.isPowerOfTwo

fun main() {
    println(isPowerOfTwo(0))
    println(isPowerOfFour(4))
    println(isPowerOfFour(16))
    println(isPowerOfFour(64))


}

fun isPowerOfFour(n: Int): Boolean {
    if (n == 0) return true
    if (n.countOneBits() != 1) return false
    var comparator = 1
    for (i in 1..16) {
        if (n == comparator) return true
        comparator = comparator shl 2
    }
    return false
}