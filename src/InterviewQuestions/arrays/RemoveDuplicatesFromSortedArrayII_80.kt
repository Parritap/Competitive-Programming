package InterviewQuestions.arrays

fun main() {
    val array = intArrayOf(0,0,1,1,1,1,2,3,3)
    removeDuplicates(array)
    print(array.contentToString())
}

fun removeDuplicates(nums: IntArray): Int {
    var j = nums.size - 1
    var previous = nums[0] //for number
    var aux = 0;
    var isRep = false // is Repeated
    var current: Int
    for (i : Int in 1 until j) {
        current = nums[i]
        if (current != previous) {
            previous = current
            isRep = false
            continue
        } else if (!isRep) {
            isRep = true
        } else {
            move(nums, i, j)
            j--
        }

    }
    return j
}

fun move (array : IntArray, i : Int, j : Int) {
    var aux : Int
    for (e : Int in i until j){
        aux = array[e+1]
        array[e+1] = array[e]
        array[e] = aux
    }
}


//fun removeDuplicates(nums: IntArray): Int {
//    var j = nums.size - 1
//    var n = nums[1]
//    var isRep = false // is Repeated
//    var p: Int // Previous
//    var c: Int // Current
//    for (i in 1 until j) {
//        p = nums[i - 1]
//        c = nums[i]
//        if ((p == c) and !isRep) isRep = true
//        else if ((nums[i - 1] == nums[1]) and isRep) {
//
//        }
//    }
//    return -1
//}