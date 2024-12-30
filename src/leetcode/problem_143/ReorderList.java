package leetcode.problem_143;

import leetcode.classes.ListNode;

import java.util.Stack;


public class ReorderList {
    public static void main(String[] args) {
        ListNode list = ListNode.arrayToListNode(new int[]{1, 2, 3});
        list.print();
        reorderList(list);
        list.print();
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        Stack<ListNode> stack = toStack(findMiddle(head));
        var lastVal = stack.getLast().val;
        ListNode init = head;
        ListNode i_next;
        ListNode tail;

        while (!stack.isEmpty()) {
            i_next = init.next;
            tail = stack.pop();
            init.next = tail;
            tail.next = i_next;
            init = i_next;
        }

        // Add this line to prevent cycle
        if (lastVal % 2 == 0) {
            init.next.next = null;
        } else {
            init.next = null;
        }
    }

    public static Stack<ListNode> toStack(ListNode node) {
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        return stack;
    }

    public static int traverse(ListNode node) {
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    public static ListNode findMiddle(ListNode node) {
        int n = traverse(node);
        ListNode tail = node;
        for (int i = 0; i < n / 2 + 1; i++) {
            tail = tail.next;
        }
        return tail;
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