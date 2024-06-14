package leetcode.problem_2037

import kotlin.math.absoluteValue

fun main() {
    val seats = intArrayOf(3,1,5)
    val students = intArrayOf(2,7,4)
    val res = minMovesToSeat(seats, students)
    seats.forEach { print("$it, ") }
    println()
    students.forEach { print("$it, ") }
    println(res)
}

fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    var moves = 0
    seats.sort()
    students.sort()
    for (i in 0 until seats.size) moves += ( seats[i] - students[i]).absoluteValue
    return moves
}
