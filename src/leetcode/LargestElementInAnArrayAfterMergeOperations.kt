fun main() {
    val array2 = intArrayOf(56,67,18,81,95,41,39,56,63,70,56,31,84,46,28,38,27,56,13,10,58,16,85,21,63,8);
    println(maxArrayValue(array2))
    array2.forEach { e -> print("$e, ") }
}



fun maxArrayValue(nums: IntArray): Int {
    var idx = nums.size - 1
    //Buscar el primer indice en el cual empezar a sumar.
    for (i in nums.size - 1 downTo 1) {
        if (nums[i] >= nums[i - 1]) {
            idx = i
            break
        }
    }

    //println("Primer indice es $idx");

    if (idx == 0) return nums.reduce { c, e -> c + e }

    while (idx >= 1 && nums[0] != -1) {
        //Decrementa el puntero si el número a la izquierda es mayor.
        if (nums[idx] < nums[findNextNumIndex(nums, idx)]) {
            idx = findNextNumIndex(nums, idx)
            continue
        }
        val next = findNextNumIndex(nums, idx) //El indice del nuevo numero a la izquierda a sumar
        if (next == -1) break
        nums[idx] = nums[idx] + nums[next]
        nums[next] = -1
    }
    return nums.max();
}

/**
Encuentra el indice del siguiente número en reversa que es diferente de -1
@return -1 todos los números a la izquierda de array[idx] son -1.
 */
fun findNextNumIndex(array: IntArray, idx: Int): Int {
    for (i in idx - 1 downTo 0) {
        if (array[i] != -1) return i
    }
    return -1
}

