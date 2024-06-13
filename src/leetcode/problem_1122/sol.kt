package leetcode.problem_1122

import kotlin.contracts.contract

fun main(args: Array<String>) {

    val result = relativeSortArray(arr1, arr2)
    result.forEach { print("$it, ") }

    (0 until 0).forEach { println (it) }
}
//Not Efficient
fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    //Declares Int array of size arr1.
    var index = 0
    val list: IntArray = IntArray(arr1.size) { -1 }
    arr2.forEach { e ->
        val coincidences: Int = (arr1.count { it == e })
        (0 until coincidences).forEach { list[index] = e; index++ }
    }
    //Search all elements NOT in arr2.
    val odds = IntArray(list.size - (list.count { it != -1 }))
    var od_index = 0

    arr1.forEach { e ->
        if (!arr2.any { it == e } && !odds.contains(e)) {
            val coincidences = (arr1.count { e == it })
            (0 until coincidences).forEach { odds[od_index] = e; od_index++ } //Index
        }
    }
    odds.sort()
    odds.forEach { list[index] = it; index++ }
    return list
}