package leetcode.problem_24;


public class SampleClass {

    public static void main(String[] args) {
        ListNode l1 = ListNode.arrayToListNode(new int[]{1, 2, 3, 4});
        l1 = swapPairs(l1);
        System.out.println(l1);
    }

    public static ListNode swapPairs(ListNode node) {
        if (node == null || node.getNext() == null) return node;
        ListNode dest = node.getNext();
        ListNode next = node.getNext().getNext();

        dest.setNext(node);
        node.setNext(swapPairs(next));
        return dest;
    }
}


class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public static ListNode arrayToListNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.setNext(new ListNode(arr[i]));
            current = current.getNext();
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.getVal()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }
}