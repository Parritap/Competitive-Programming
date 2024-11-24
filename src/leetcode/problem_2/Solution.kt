package leetcode.problem_2

import java.math.BigInteger

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


fun main() {
    val sol = Solution()
    //val l1 = ListNode(5, ListNode(6))
    //val l2 = ListNode(5, ListNode(4, ListNode(9)))
    val l1 = ListNode.arrayToListNode(
        intArrayOf(
            1,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            1
        )
    )
    val l2 = ListNode.arrayToListNode(intArrayOf(5, 6, 4))


    println("l1: ${l1.toString()}\nl2: $l2")
    println("Numbers are: ${sol.buildNum(l1)} and ${sol.buildNum(l2)}")

    val node = sol.addTwoNumbers(l1, l2)
    node.print()
}

class ListNode(var `val`: Int? = null, var next: ListNode? = null) {
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

    fun Int.pow(exp: Int): BigInteger {
        val base = BigInteger.valueOf(this.toLong());
        var num = BigInteger.valueOf(0)
        for (i in 0 until exp) {
            num *= base
        }
        return num
    }

    operator fun Int.times(times: BigInteger): BigInteger {
        var res = BigInteger.valueOf(0)
        for (i in 0 until times) {

        }
    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        val n1 = buildNum(l1!!)
        val n2 = buildNum(l2!!)
        //return ListNode(-1, null)
        return convertToLinkedList(n1 + n2)
    }

    fun buildNum(node: ListNode, num: BigInteger = BigInteger.valueOf(0), digits: Int = 0): BigInteger {
        val res: BigInteger = num.plus(node.`val`!! * BigInteger.valueOf(10.pow(digits).toLong()))
        return if (node.next == null) res
        else buildNum(node.next!!, res, digits + 1)
    }

    private fun convertToLinkedList(num: Long): ListNode {
        val str = num.toString().reversed()
        val start = ListNode(str[0].digitToInt())
        var outer = start
        for (i in 1 until str.length) {
            outer.next = ListNode(str[i].digitToInt())
            outer = outer.next!!
        }
        return start
    }
}

