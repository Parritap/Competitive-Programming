package leetcode.problem_2

fun main() {
    val sol = Solution()

    val l1 = ListNode.arrayToListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9))
    val l2 = ListNode.arrayToListNode(intArrayOf(9, 9, 9, 9))
    val res = sol.addTwoNumbers(l1, l2)
    println(l1)
    println(l2)
    println(res)
}


class ListNode(
    var `val`: Int? = null,
    var next: ListNode? = null
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


class Solution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return add(l1, l2)
    }

    fun bothNulls(l1: ListNode?, l2: ListNode?): Boolean {
        return (l1 == null) && (l2 == null)
    }


    private fun add(l1: ListNode?, l2: ListNode?): ListNode {
        var node1 = l1
        var node2 = l2

        var n1: Int
        var n2: Int
        var carry = 0
        var current: ListNode? = ListNode(0)
        val head = current!!

        while (!bothNulls(node1, node2)) {

            n1 = node1?.`val` ?: 0
            n2 = node2?.`val` ?: 0

            val digit = (n1 + n2).rem(10) + carry
            carry = if (digit == 10) 1 else (n1 + n2) / 10 // This will be either 1 or 0.
            current?.`val` = if (digit == 10) 0 else digit

            node1 = node1?.next
            node2 = node2?.next

            if (!bothNulls(node1, node2)) {
                current?.next = ListNode(0)
                current = current?.next!!
            }
        }

        if (carry == 1) {
            current!!.next = ListNode(1, null)
        }
        return head
    }
}