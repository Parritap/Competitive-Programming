package problems

fun main() {
    val array = intArrayOf(1, 5, 233, 7) //true -> p1 can win cuz he's playing optimally.
    val array2 = intArrayOf(1, 5, 2) //false -> p1 can never win.
    println(PredictTheWinner((array.asList())))
    println(PredictTheWinner((array2.asList())))
}

//This is not my answer.
fun dfs(i: Int, j: Int, nums: List<Int>, turn: Int): Int {
    if (i == nums.size || j == -1) return 0
    if (i > j) return 0
    if (turn == 0) {
        return Math.max(nums[i] + dfs(i + 1, j, nums, 1), nums[j] + dfs(i, j - 1, nums, 1))
    } else {
        return Math.min(-nums[i] + dfs(i + 1, j, nums, 0), -nums[j] + dfs(i, j - 1, nums, 0))
    }
}

fun PredictTheWinner(nums: List<Int>): Boolean {
    val n = nums.size
    val value = dfs(0, n - 1, nums, 0)
    return value >= 0
}