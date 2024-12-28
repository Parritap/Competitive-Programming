package leetcode.problem_60

fun main() {
    println(getPermutation(4, 15))
}


fun getPermutation(n: Int, k: Int): String {
    val list = IntArray(n) { it + 1 }
    //list.forEach { print("$it ") }
    return calPermutations(list, k - 1, "")
}

fun calPermutations(list: IntArray, k: Int, res: String): String {
    if (list.isEmpty()) return res
    val div = (list.size - 1).fact()
    val pos = k / div
    val newList = list.filterIndexed { index, _ -> index != pos }.toIntArray()
    val K = if (k == 0) 0 else k - (div * pos)
    return calPermutations(newList, K, res + list[pos].toString())
}

fun Int.fact(): Int {
    var factorial: Int = 1
    for (i in 1..this) factorial *= i
    return factorial
}