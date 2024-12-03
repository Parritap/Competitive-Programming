package leetcode.problem_10

import java.util.*

/**
 *Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 */

fun main() {
    //val b = Solution().isMatch("aabcx", "a*b*c")
    val b = Solution().isMatch("aa", "a*b*")
    println(b)

}

class Solution {

    //Kotlin extension function
    private fun Stack<String>.getTheLast(): String? {
        return if (this.isEmpty()) null else this.pop()
    }

    fun isMatch(s: String, p: String): Boolean {
        //First block fills the stack with individual patterns

        val stack = Stack<String>()
        var i = p.length - 1
        while (i >= 0) {
            if (p[i] == '*') {
                stack.push("*${p[i - 1]}")
                i -= 2
            } else {
                stack.push(p[i].toString())
                --i
            }
        }
        stack.reversed().forEach { println("$it ") }

        //Now lets check the string s
        val str = Stack<String>()
        s.reversed().forEach { str.push(it.toString()) }
        var patt: String? = stack.pop() //It is guaranteed that first pop won't be null.
        var c: String? = str.pop()
        while (c != null && (!stack.empty() || !str.empty())) {
            if (matches(patt, c)) {
                patt = (if (!stack.empty()) stack.pop() else null)
                c = str.getTheLast()

            } else if (patt?.length == 2) {
                if (c[0] == patt[1] || patt[1] == '.') {
                    c = str.getTheLast()
                    continue
                } else {
                    if (!stack.empty()) {
                        patt = stack.pop()
                    }
                }
            }
        }
        return str.empty() && stack.empty()
    }

    private fun matches(patt: String?, c: String) = patt?.length == 1 && (c == patt || patt[0] == '.')


}

