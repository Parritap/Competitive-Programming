package leetcode.problem_24

import leetcode.classes.ListNode


fun main() {
    //val l1 = ListNode.arrayToListNode(intArrayOf(1, 2, 3, 4, 5, 6, 7))
    val l1 = ListNode.arrayToListNode(intArrayOf(1, 2, 3, 4))
    swapPairs(l1)
    println(l1)
}

fun swapPairs(node: ListNode?): ListNode? {
    if (node?.next == null) return node
    val dest = node.next
    val next = node.next!!.next

    dest!!.next = node
    node.next =
        swapPairs(next)
    return dest
}

fun swap(node: ListNode?): ListNode? {
    if (node?.next == null) return node
    val dest = node.next
    val next = node.next!!.next

    dest!!.next = node
    node.next = swap(next)
    return dest
}





