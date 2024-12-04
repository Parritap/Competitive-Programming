package leetcode.problem_26


fun main() {
    val test = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
    //val test = intArrayOf(1, 1, 2)
    val k = Solution().removeDuplicates(test)
    test.forEach { print("$it ") }

}

class Solution {

    fun removeDuplicates(nums: IntArray): Int {
        var current: Int = nums[0]
        var index = 1
        var k = 1

        for (i in 1 until nums.size) {
            if (nums[i] != current) {
                k++
                nums[index] = nums[i]
                current = nums[i]
                index++
            }
        }
        return k
    }

}