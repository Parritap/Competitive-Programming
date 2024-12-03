package leetcode.problem_75


fun main() {
    val list = intArrayOf(2, 1, 2)
    Solution().sortColors(list)
    list.forEach { print("$it ") }
}


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
                if (mem == 0 || mem == 2) continue
            }
            i++
        }
    }
}