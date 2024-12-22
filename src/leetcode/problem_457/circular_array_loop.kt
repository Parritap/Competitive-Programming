package leetcode.problem_457

fun main() {
    //val array = intArrayOf(2, -1, 1, 2, 2)
    //val array = intArrayOf(-1, -2, -3, -4, -5, 6)
    //val array = intArrayOf(1, -1, 5, 1, 4)
    //val array = intArrayOf(1, 1)
    val array = intArrayOf(-8, -1, 1, 7, 2)
    print(array.traverse(0))
    //println(circularArrayLoop(array))
}

fun circularArrayLoop(nums: IntArray): Boolean {
    var sol = false
    val visited = BooleanArray(nums.size)
    //TODO Lidiar con el cambio de signo. Es decir, traversar de positivos a negativos y biceversa.
    //Traverse each node individually.
    for (i in nums.indices) {
        if (sol) break //
        val sign = nums[i].isPos()
        val aux = BooleanArray(nums.size) //Memory of visited nodes.
        var c = i // Index that lets us jump from node to node. Let us start in node i. So c = i.
        for (j in 0..nums.size) {
            //If crossing an already visited node, stop, since we already know that
            //node won't lead us to a loop.
            // Also, if we encounter a loop of just one node, break.
            if (visited[c] || nums[c] % nums.size == 0) {
                visited[c] = true
                break
            }

            //Lastly, if we encounter a change sequence sign, break.
            if (sign != nums[c].isPos()) {
                visited[i] = true
                break
            }

            // If jumping to an already crossed node, it implies that somehow we reached a loop.
            if (aux[c]) {
                sol = true
                println(i)
                break
            }
            aux[c] = true
            c = nums.traverse(c)
        }
        visited[i] = true
    }
    return sol
}

fun Int.isPos(): Boolean {
    return this > 0;
}

//Returns the index without going out of bounds. This is achieved
// by traversing an array in a circular way, either going to the left or to the rigth.
fun IntArray.traverse(index: Int): Int {
    val s = this[index] % size
    return when {
        s == 0 -> index
        s.isPos() -> (index + s) % size
        !s.isPos() && index + s < 0 -> size + index + s
        else -> index + s
    }
}
