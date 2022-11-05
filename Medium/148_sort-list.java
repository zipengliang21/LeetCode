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
// quick sort approach
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int pivotValue = head.val;
        ListNode node = head.next;
        // value <=pivotValue
        ListNode lowNodeDummy = new ListNode(-1);
        ListNode lowNode = lowNodeDummy;

        // value > pivotValue
        ListNode highNodeDummy = new ListNode(-1);
        ListNode highNode = highNodeDummy;

        while (node != null) {
            if (node.val < pivotValue) {
                lowNode.next = node;
                lowNode = lowNode.next;
            } else {
                highNode.next = node;
                highNode = highNode.next;
            }
            node = node.next;
        }

        // connect three part: lowNode, head, highNode
        lowNode.next = head;
        head.next = null;
        highNode.next = null;

        lowNode = sortList(lowNodeDummy.next);
        highNode = sortList(highNodeDummy.next);

        head.next = highNode;

        return lowNode;
    }
}

// merge sort
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddleOfList(head);

        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }

    private ListNode findMiddleOfList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        }

        if (l2 != null) {
            node.next = l2;
        }

        return dummyNode.next;
    }
}