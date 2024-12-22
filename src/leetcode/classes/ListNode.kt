package leetcode.classes

class ListNode(
    var `val`: Int? = null, var next: ListNode? = null
) {
    override fun toString(): String {
        var aux: ListNode? = this
        var str = ""
        while (aux != null) {
            str += aux.`val`?.toString() ?: "null"
            if (aux.next != null) {
                str += " -> "
            }
            aux = aux.next
        }
        return str
    }

    companion object {
        @JvmStatic
        fun arrayToListNode(arr: IntArray): ListNode {
            val start = ListNode(arr[0])
            var outer = start
            for (i in 1 until arr.size) {
                outer.next = ListNode(arr[i])
                outer = outer.next!!
            }

            return start
        }
    }

    fun print() {
        var outer: ListNode? = this
        var str = ""
        while (outer != null) {
            str += outer.`val`?.toString() ?: "null"
            str += if (outer.next != null) " " else ""
            outer = outer.next
        }
        print(str)
    }
}