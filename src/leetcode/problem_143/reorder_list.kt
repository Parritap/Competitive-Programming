package leetcode.problem_143

import leetcode.classes.ListNode
import java.util.Stack


fun main() {
    val list = ListNode.arrayToListNode(intArrayOf(1, 2, 3, 4, 5, 6, 7))
    list.print()
    reorderList(list)
    list.print()
}

fun reorderList(head: ListNode?): Unit {
    val stack: Stack<ListNode> = head!!.findMiddle().toStack()
    var init = head
    var i_next: ListNode?
    var tail: ListNode
    var i = 0
    while (!stack.isEmpty()) {
        i_next = init!!.next
        tail = stack.pop()
        init.next = tail
        tail.next = i_next
        init = i_next
    }
}

fun ListNode.toStack(): Stack<ListNode> {
    var tail: ListNode? = this
    val stack: Stack<ListNode> = Stack()
    while (tail != null) {
        stack.push(tail)
        tail = tail.next
    }
    return stack
}

fun traverse(node: ListNode?): Int {
    var tail = node
    var counter = 0
    while (tail != null) {
        counter++
        tail = tail.next
    }
    return counter
}

fun ListNode.findMiddle(): ListNode {
    val n: Int = traverse(this)
    var tail: ListNode = this
    (0 until n / 2 + 1).forEach {
        tail = tail.next!!
    }
    return tail
}