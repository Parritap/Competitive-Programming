package leetcode.problem_21

import leetcode.problem_88.merge


fun main() {
    val l1 = ListNode.arrayToListNode(intArrayOf(1, 2, 4))
    val l2 = ListNode.arrayToListNode(intArrayOf(1, 3, 4))
    //val l1 = ListNode()
    //val l2 = ListNode()
    val sol = mergeTwoLists(l1, l2)
    sol!!.print()

}


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


fun ListNode.walk(): Boolean = this.next != null


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    if (l1 == null) return l2
    if (l2 == null) return l1
    if (l1.`val`!! <= l2.`val`!!) {
        l1.next = mergeTwoLists(l1.next, l2)
        return l1
    } else {
        l2.next = mergeTwoLists(l1, l2.next)
        return l2
    }
}


