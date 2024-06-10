package leetcode.problem_974

import kotlin.math.absoluteValue

fun main( args : Array<String>) {
    val map: MutableMap<Int, Int> = mutableMapOf()
    var sum = 0
    print(subarraysDivByK(intArrayOf(-1,2,9), 2))
}

fun subarraysDivByK(nums: IntArray, k: Int): Int {

    val map: MutableMap<Int, Int> = mutableMapOf(0 to 1)
    var counter = 0
    var sum = 0
    var mod: Int

    for (i in 0 until nums.size) {
        sum += nums[i].mod(3)
        mod = sum.mod(k)
        if (map[mod] == null) map[mod] = 1
        else {
            counter += map[mod]!!
            map[mod] = map[mod]!! + 1
        }
    }
    return counter
}