package leetcode.problem_2

fun main() {
    val sol = Sol()

    val l1 = ListNode.arrayToListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9))
    val l2 = ListNode.arrayToListNode(intArrayOf(9, 9, 9, 9))
    // Res = [8,9,9,9,0,0,0,1]
    val res = sol.addTwoNumbers(l1, l2)
    println(l1)
    println(l2)
    println(res)
}

class Sol {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return add(l1, l2)
    }

    private fun bothNulls(l1: ListNode?, l2: ListNode?): Boolean {
        return (l1 == null) and (l2 == null)
    }

    private fun add(l1: ListNode?, l2: ListNode?): ListNode? {
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

        if (carry == 1) current?.`val` = 1
        return head
    }
}