package leetcode.problem_5

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=dynamic-programming
 * Given a string s, return the longest palindromic substring in s.
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 */

fun main() {
    println(longestPalindrome("ababbad"))
}

/**
 * The following solution makes use of dynamic programming in order to solve the problem.
 * It is not the fastest nor the most memory efficient.
 */
fun longestPalindrome(s: String): String {
    val n = s.length
    var count = -1
    val dp = Array(n) { BooleanArray(n) { false } }
    var indexes = Pair(-1, -1)

    for (g in 0 until n) {
        for (i in 0 until n - g) {

            val j = i + g
            when (g) {
                0 -> dp[i][j] = true
                1 -> dp[i][j] = s[i] == s[j]
                else -> dp[i][j] = (s[i] == s[j]) and (dp[i + 1][j - 1])
            }
            if (dp[i][j]) {
                val aux = s.substring(i, j + 1).length
                if (aux > count) {
                    count = aux
                    indexes = Pair(i, j)
                }
            }
        }
    }
    return s.substring(indexes.first, indexes.second + 1)
}
