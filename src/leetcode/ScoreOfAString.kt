package leetcode

import kotlin.math.absoluteValue

fun main() {
    //println(sol1("hello"))
    println(sol2("hello"));
}

fun sol2(s: String): Int {
    var sum = 0;
    val intArray = s.map { e -> e.code }
    intArray.forEachIndexed { i, e ->
        if (i < intArray.size - 1) sum += (e - intArray[i + 1]).absoluteValue
    }
    return sum;
}

fun sol1(s: String): Int {
    var sum = 0
    var intArray = "hello".toCharArray().map { e -> e.code }
    for (i in 0..(intArray.size - 2)) {
        sum += (intArray[i] - intArray[i + 1]).absoluteValue;
    }
    return sum
}

fun scoreOfString(s: String): Int {
    var sum = 0
    var intArray = s.toCharArray().map { e -> e.code }
    for (i in 0..(intArray.size - 2)) {
        sum += (intArray[i] - intArray[i + 1]).absoluteValue;
    }
    return sum
}
