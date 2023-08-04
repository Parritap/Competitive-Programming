package InterviewQuestions.arrays

import java.util.TreeMap

fun main() {
}

fun majorityElement(nums: IntArray): Int? {
    nums.sort()
    return nums[nums.size / 2]
}