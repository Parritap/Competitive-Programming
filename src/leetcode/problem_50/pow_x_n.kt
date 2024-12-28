package leetcode.problem_50

import kotlin.math.abs
import kotlin.math.pow

fun main() {
    //val solution = (myPow(2.0, Int.MIN_VALUE)) //2147483648
    val solution = (myPow(2.0, Int.MIN_VALUE)) //2147483648 -- -2147483648
    print(solution)
}

fun myPow(x: Double, n: Int): Double {
    return when {
        n == 0 -> 1.0
        x == 1.0 -> 1.0
        x == -1.0 -> if (n % 2 == 0) 1.0 else -1.0
        n == Int.MIN_VALUE -> 1 / (aux(x, abs(Int.MIN_VALUE + 1)) * n)
        (n < 1) -> 1 / aux(x, abs(n))
        else -> aux(x, abs(n))
    }
}

fun aux(x: Double, n: Int): Double {
    if (n == 1) return x
    val div: Int = n / 2
    val pow = aux(x, div)
    return if (n % 2 == 0) (pow * pow) else (pow * pow * x)
}
