package problems

import kotlin.math.max


fun main() {
    //val array: IntArray = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 7, 5, 3, 1, 0);
    //val array: IntArray = intArrayOf(1 , 4, 10, 5, 3, 2, 1);
    val array: IntArray = intArrayOf(3, 4, 5, 1);
    val array2 = intArrayOf(0,1,0);
    print(solution(array))
}




fun solution(arr: IntArray): Int {
    var i = 0;
    var j = arr.size - 1;
    var mid: Int;

    while (true) {
        if (j-i==1) return (if (arr[i]>arr[j]) i else j)
        mid = i + (j - i) / 2
        if (arr[mid-1] > arr [mid]) j = mid else i = mid;
    }
}
