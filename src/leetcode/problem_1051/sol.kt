package leetcode.problem_1051

import java.util.*

fun main(args: Array<String>) {

}

fun heightChecker(heights: IntArray): Int {
    var sum = 0;
    val sortedArray: IntArray = heights.copyOf()
    sortedArray.sort()

    sortedArray.forEachIndexed { i, e ->
        if (heights[i] != sortedArray[i]) sum++
    }
    return sum
}
