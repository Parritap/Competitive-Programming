package leetcode.problem_945

import java.util.*

fun main(args: Array<String>) {
    val array = intArrayOf(1,2,2)
    println(minIncrementForUnique(array))
}

fun minIncrementForUnique(nums: IntArray): Int {
    val map: TreeMap<Int, Int> = TreeMap()
    nums.forEach { e -> map[e] = map.getOrDefault(e, 0) + 1 }

    var counter = 0
    var i: Int = map.firstEntry().key
    var nk: Int? = map.higherKey(i)

    while (!(map[i] == 1 && nk == null)) {
        if (map[i]!! > 1) {
            map[i] = map[i]!! - 1
            map[i + 1] = map.getOrDefault(i + 1, 0) + 1
            nk = map[i + 1]
            counter++
        } else {
            i = map.higherKey(i)
            nk = map.higherKey(i)
        }
    }
    return counter
}