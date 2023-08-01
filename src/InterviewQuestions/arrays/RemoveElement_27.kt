package InterviewQuestions.arrays

fun main() {
    val array = intArrayOf(0,1,2,2,3,0,4,2)
    println(removeElement(array, 2))
    print(array.contentToString())

}

fun removeElement(nums: IntArray, value: Int): Int {
    var k = 0
    var aux = 0
    var i = 0;
    var j = nums.size - 1
    while (i < j) {
        if (nums[j] == value) {
            j--
            k++
        }
        if (nums[i] == value) {
            aux = nums[j]
            nums[j] = nums[i]
            nums[i] = aux
            j--
            k++
        }
        i++
    }
    return k
}