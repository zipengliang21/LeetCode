package Medium;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int length = getLength(head);
        k = k % length;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = dummyNode.next;
        dummyNode.next = slow.next;
        slow.next = null;

        return dummyNode.next;
    }

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}