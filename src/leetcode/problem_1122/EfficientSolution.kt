package leetcode.problem_1122

import java.util.TreeMap

fun main(args: Array<String>) {
   // val arr1 = intArrayOf(2, 21, 43, 38, 0, 42, 33, 7, 24, 13, 12, 27, 12, 24, 5, 23, 29, 48, 30, 31)
   // val arr2 = intArrayOf(2, 42, 38, 0, 43, 21)
   // val result = EfficientSolution().relativeSortArray(arr1, arr2)
   // result.forEach { println("$it, ") }
}

class EfficientSolution {

    //fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
    //    // Number : frequency
    //    val map = TreeMap<Int, Int>()
    //    val odds: MutableList<Int> = mutableListOf()
    //    val result = IntArray(arr1.size)
    //    var index = 0
    //    arr1.forEach {
    //        if (map[it] != null) map[it] = map[it]!! + 1 else map[it] = 1
    //    }

    //    arr2.forEach {
    //        if (it in map) (0 until map[it]!!).forEach { e -> result[index] = it; index ++ }
    //        else
    //    }

    //   // map.forEach { (k, v) ->
    //   //     //Llenamos primero aquellos que existen en el arreglo 2.
    //   //     if (k in arr2) (0 until v).forEach { result[index] = k; index++ }
    //   //     //si no existe, entonces lo agregamos al otro arreglo auxiliar.
    //   //     else (0 until v).forEach { odds.add(k) }
    //   // }


    //    odds.sort()
    //    odds.forEach { result[index] = it; index++ }


    //    return result
    //}
}