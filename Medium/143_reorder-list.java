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
    public void reorderList(ListNode head) {
        List newNode = null;

        // get the middle of the list
        ListNode middle = getMiddleOfList(head);

        // reverse
        ListNode tail = reverseList(middle.next);
        middle.next = null;

        // merge
        mergeList(head, tail);
    }

    private ListNode getMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private void mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        int count = 0;

        while (head1 != null && head2 != null) {
            if (count % 2 == 0) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }

            node = node.next;
            count++;
        }

        if (head1 != null) {
            node.next = head1;
        }

        if (head2 != null) {
            node.next = head2;
        }
    }
}
