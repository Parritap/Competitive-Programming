package problems

import kotlin.math.abs
import kotlin.math.sqrt

fun main() {
    println(abs(-2147483648))
    print(abs(Int.MAX_VALUE))
    Int.MIN_VALUE
}

//simple way:
fun brutePow(x: Double, n: Int): Double { //Does not take in count negative exponents.
    if (n == 0 || x == 1.0) return 1.0;
    var sol = x;
    for (i in 1 until Math.abs(n)) sol *= x;
    return sol;
}

fun myPow(x: Double, n: Int): Double {
    if (n == 0) return 1.0;
    val sol = myPowAux(x, n)
    return (if (n > 0) sol else 1 / sol)
}

fun myPowAux(x: Double, n: Int): Double {
    if (n == 0 || x == 1.0) return 1.0;
    if (n == 1 || n == -1) return x;
    val remainder = n % 2;
    return brutePow(myPowAux(x, Math.abs(n / 2)), 2) * brutePow(x, remainder);
}
