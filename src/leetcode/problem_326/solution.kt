package leetcode.problem_326


fun isPowerOfThree(n: Int): Boolean {
    var pow = 1
    while (pow < n) {
        println("Pow is -> $pow")
        pow += pow shl 1
    }
    return pow == n
}