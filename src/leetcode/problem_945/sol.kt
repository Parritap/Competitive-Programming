package leetcode.problem_945

import com.sun.source.tree.Tree
import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val array = intArrayOf(1, 1, 2, 2, 3, 7)
    println(minIncrementForUnique(array))
}

fun minIncrementForUnique(nums: IntArray): Int {
    val map: TreeMap<Int, Int> = TreeMap()
    nums.forEach { e -> map[e] = map.getOrDefault(e, 0) + 1 }

    var counter = 0
    var n: Int
    var flag = false
    var index : Int = -1

    while (index != map.lastKey())
        for ((k, v) in map) {
            index = k
            if (v > 1) {
                n = v - 1
                counter += (n * (n - 1)) / 2
                (k + 1..k + v - 1).forEach { map[it] = map.getOrDefault(it, 0) + 1 }
                break;
            }
            index = k
        }

    return counter
}