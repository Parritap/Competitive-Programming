package leetcode.problem_75

import problems.solution
import java.sql.RowIdLifetime

fun main() {
    val list = intArrayOf(0, 1, 0)
    Solution().sortColors(list)
    list.forEach { print("$it ") }
}

//Al parecer es mejor operar con ceros y unos en vez de unos y dos.
class Solution {
    fun sortColors(nums: IntArray): Unit {
        var left = 0
        var right = nums.size - 1
        var i = 0
        var mem: Int
        while (i <= right) {
            if ((nums[i] == 0)) {
                nums[i] = nums[left]
                nums[left] = 0
                left++
            }
            if ((nums[i] == 2)) {
                mem = nums[right]
                nums[i] = nums[right]
                nums[right] = 2
                right--
                if (mem == 0) continue
            }
            i++
        }
    }
}