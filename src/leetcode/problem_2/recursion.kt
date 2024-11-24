package leetcode.problem_2

fun main() {
    printNums(1)
}


fun printNums(num: Int) {
    println(num)
    if (num <= 9) printNums(num + 1) else return
    println("Kotlin$num")
}