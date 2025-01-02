package leetcode.problem_143

import leetcode.classes.ListNode


fun main() {
    val list = ListNode.arrayToListNode(intArrayOf(1, 2, 3, 4, 5, 6, 7))
    list.print()
    reorderList(list)
    list.print()
}

fun reorderList(head: ListNode?): Unit {
    // Step 1, find the middle
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }

    // Step 2, reverse the second half
    var second = slow!!.next
    var node: ListNode? = null
    slow.next = null

    while (second != null) {
        val temp = second.next
        second.next = node
        node = second
        second = temp
    }

    // Step 3, merge the two lists
    var first = head
    var last = node

    var temp1: ListNode?
    var temp2: ListNode?

    while (last != null) {
        temp1 = first!!.next
        temp2 = last.next
        first.next = last
        last.next = temp1
        first = temp1
        last = temp2
    }
}
