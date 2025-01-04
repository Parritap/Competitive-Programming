package leetcode.problem_11

import kotlin.math.max
import kotlin.math.min

fun main() {
    val height = intArrayOf(1, 2, 4, 3)
    println(maxArea(height))
}

fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var vol = calvVol(i, j, height)
    while (i != j) {
        if (height[i] < height[j]) i++ else j--
        vol = max(calvVol(i, j, height), vol)
    }
    return vol
}

//Where y is the right one and x the left one.
fun calvVol(x: Int, y: Int, list: IntArray): Int {
    val min = min(list[x], list[y]) //
    return min * (y - x)
}
