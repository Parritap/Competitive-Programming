package leetcode.problem_143;

import leetcode.classes.ListNode;

import java.util.Stack;


public class ReorderList {
    public static void main(String[] args) {
        ListNode list = ListNode.arrayToListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        list.print();
        new ReorderList().reorderList(list);
        list.print();
    }

    public void reorderList(ListNode head) {
        if (head == null) return;

        // Step 1: Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        // At this point, second is the first node of the second half of the list.
        ListNode second = slow.next;
        slow.next = null; // Breaks link with second half of the list, i.e, second.
        ListNode node = null; // It is important to initialize node to null.

        while (second != null) {
            ListNode temp = second.next; // Node to the right of second.
            second.next = node; // Reverse the link. Node works as memory to store the previous node so that we can point to the left.
            node = second; // Move node to the right.
            second = temp; // Move second to the right.
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        second = node;

        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void print() {
            ListNode node = this;
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }

        public static ListNode arrayToListNode(int[] arr) {
            ListNode head = new ReorderList().new ListNode(arr[0]);
            ListNode node = head;
            for (int i = 1; i < arr.length; i++) {
                node.next = new ReorderList().new ListNode(arr[i]);
                node = node.next;
            }
            return head;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                result.append(current.val);
                if (current.next != null) {
                    result.append(" -> ");
                }
                current = current.next;
            }
            return result.toString();
        }
    }
}