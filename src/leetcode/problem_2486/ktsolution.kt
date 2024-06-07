package leetcode.problem_2486

fun main(args: Array<String>) {
    println(appendCharacters("abcde", "a"))
}

/**
 * You are given two strings s and t consisting of only lowercase English letters.
 *
 * Return the minimum number of characters that need to be appended to the end of
 * s so that t becomes a subsequence of s.
 *
 * A subsequence is a string that can be derived from another string by deleting
 * some or no characters without changing the order of the remaining characters.
 */

fun appendCharacters(s: String, t: String): Int {
    var s_index = 0;
    var t_index = 0;
    //Buscamos las conincidencias en orden de las letras de t.
    for (i in 0 until t.length) {
        s_index = searchChar(s, s_index, t[i])
        if (s_index == -1) break else t_index++
    }
    return if (t.length - t_index == 0) 0
    else (t.length - t_index)
}

fun searchChar(s: String, sIndex: Int, c: Char): Int {
    for (i in sIndex..s.length - 1) {
        if (s.get(i) == c) return i + 1
    }
    return -1
}


