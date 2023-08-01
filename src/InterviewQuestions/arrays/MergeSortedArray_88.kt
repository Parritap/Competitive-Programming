package InterviewQuestions.arrays

import java.util.*

fun main() {
    val a1 = intArrayOf(4, 5, 6, 0, 0, 0)
    val a2 = intArrayOf(1, 2, 3)
    merge(a1, a1.size, a2, a2.size)
    print(a1.contentToString())


}

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */

fun merge(array1: IntArray, m: Int, array2: IntArray, n: Int): Unit {
    val M = array1.size
    val N = array2.size
    if (M!=0 && N!=0) {
        var j = 0;
        for (i in M - N until M) {
            array1[i] = array2[j]
            j++
        }
            Arrays.sort(array1)
    }
}

fun bubbleSort(array: IntArray): Unit {
    var aux = 0
    val n = array.size
    for (i in 0 until n - 1) {
        for (j in 0 until  n - 1 - i) {
            if (array[j] > array[j + 1]) {
                aux = array[j+1]
                array[j+1] = array[j]
                array[j] = aux
            }
        }
    }
}


fun binarySearch(array: IntArray, num: Int): Int {
    var i = 0
    var j = array.size - 1
    var mid = i + ((j - i) / 2)

    while (j - i != 0) {
        if (array[mid] == num) return mid
        if (array[mid] > num) j = mid - 1 else i = mid + 1
        mid = i + ((j - i) / 2)
    }
    return mid
}

fun shiftAndPlace(index: Int, num: Int) {

}