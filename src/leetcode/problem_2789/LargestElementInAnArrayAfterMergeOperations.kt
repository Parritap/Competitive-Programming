package leetcode.problem_2789

import java.io.File

fun main() {
    val array = readArrayFromFile("src/leetcode/nums.txt")
    println("RESULT: ${maxArrayValue(array)}")
    array.forEach {print("$it, ") }
}

fun maxArrayValue(nums: IntArray): Long {
    var current : Long = nums[nums.size-1].toLong();

    for (i in nums.size-1 downTo 1) {
        if ( current <  nums[i-1] ){
            current = nums[i-1].toLong()
        }else{
            current += nums[i-1]
        }
    }
    return current;
}

fun readArrayFromFile(url: String): IntArray {
    val file = File(url)
    val lines = file.readLines()
    val array = lines[0].split(",").map{ it.toInt() }.toIntArray()
    return array
}