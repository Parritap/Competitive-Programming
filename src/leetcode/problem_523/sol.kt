package leetcode.problem_523

fun main(args : Array<String>) {
    val array = intArrayOf(1,3,0,6)
    val k = 6
    print(checkSubarraySum(array, k))
}
fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    val map = hashMapOf( (nums[0]% k) to 0)
    var sum = nums[0]
    var prevIndex : Int?

    for (i in 1 until nums.size) {
        sum+=nums[i]
        prevIndex = if (nums[i] != 0 ) map.put(sum%k, i) else null
        if ((sum%k==0) ||
            (prevIndex!=null && (i - prevIndex > 1)) ||
            (nums[i] == nums[i-1] && nums[i] == 0 ) ){
            return true
        }
    }
    return false
}