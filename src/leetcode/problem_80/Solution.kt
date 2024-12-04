package leetcode.problem_80

import leetcode.problem_945.minIncrementForUnique

fun main() {
    val test = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    //val test = intArrayOf(1, 1, 2)
    val k = Solution().removeDuplicates_v2(test)
    println("K is: $k")
    test.forEach { print("$it ") }
}

class Solution {

    fun removeDuplicates(nums: IntArray): Int {
        var current: Int = nums[0]
        var index = 1
        var repeated = false
        var k = 1
        var num: Int
        var max = Int.MIN_VALUE
        for (i in 1 until nums.size) {
            num = nums[i]
            if (num != current) {
                max = num
                k++
                nums[index] = num
                current = num
                index++
                repeated = false
                //Number is the same
            } else if (!repeated) {
                nums[index] = num
                repeated = true
                k++
                index++
            } else {
                //nums[i] = Int.MIN_VALUE
            }
        }
        return k
    }

    // Efficient solution
    fun removeDuplicates_v2(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size

        var slow = 2
        for (fast in 2 until nums.size) {
            val low = nums[slow - 2]
            val high = nums[fast]
            if (nums[slow - 2] != nums[fast]) {
                nums[slow++] = nums[fast]
            }
        }
        return slow
    }
}