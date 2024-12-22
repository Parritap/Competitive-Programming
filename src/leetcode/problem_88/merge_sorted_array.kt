package leetcode.problem_88


fun main() {
    val a = intArrayOf(1, 2, 3, 0, 0, 0)
    val b = intArrayOf(2, 5, 6)
    merge(a, 3, b, b.size)
    a.forEach { print("$it ") }

}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var a = 0
    var b = 0

    while (a < m) {
        if (nums1[a] == nums2[b]) {
            swap(nums1, a + 1, nums2, b)
            a++
        }
        if (nums1[a] > nums2[b]) {
            swap(nums1, a, nums2, b)
            a++
        }
        if (nums1[a] < nums2[b]) a++
    }

    for (i in a until nums1.size) {
        nums1[i] = nums2[b]
        b++
    }
}

fun swap(nums1: IntArray, i: Int, nums2: IntArray, j: Int) {
    val aux = nums1[i]
    nums1[i] = nums2[j]
    nums2[j] = aux
}