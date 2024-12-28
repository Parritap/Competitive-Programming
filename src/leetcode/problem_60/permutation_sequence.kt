package leetcode.problem_60

fun main() {
    println(getPermutation(4, 15))
}


fun getPermutation(n: Int, k: Int): String {
    return calPermutations(n, k, "")
}

fun calPermutations(n: Int, k: Int, res: String): String {
    if (n == 0) return res
    val div = (n - 1).fact()
    val pos = (k / div) + 1
    return calPermutations(n - 1, k - (div * pos), res + pos.toString())
}

fun Int.fact(): Int {
    var factorial: Int = 1
    for (i in 1..this) factorial *= i
    return factorial
}