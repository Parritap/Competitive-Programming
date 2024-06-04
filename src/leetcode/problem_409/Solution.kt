package leetcode.problem_409

fun main(string: Array<String>) {
    println(longestPalindrome("bananas"))
}

fun longestPalindrome(s: String): Int {
    val charArray = s.toCharArray();
    charArray.sort()
    charArray.forEach { print("$it, ") }

    var c = charArray[0]
    var cantidadPares: Int = 0;
    var strike: Int = 1; // Cantidad de consecutiva de veces que se repite.

    for (i in 1..charArray.size - 1) {
        if (c != charArray[i]) {
            c = charArray[i];
            cantidadPares += strike.div(2) //División entera en Kotlin.
            strike = 1;
        } else {
            strike++
        }
    }
    cantidadPares += strike.div(2) //División entera en Kotlin.
    cantidadPares = cantidadPares * 2

    return (if ( (charArray.size % 2 == 1) or (cantidadPares < charArray.size)) cantidadPares + 1 else cantidadPares)
}
