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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummtNode = new ListNode(-1);
        dummtNode.next = head;

        ListNode pre = dummtNode;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode curNode = pre.next;

        for (int i = left; i < right; i++) {
            ListNode temp = curNode.next;
            curNode.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummtNode.next;
    }
}
