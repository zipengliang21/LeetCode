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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode node = dummyNode;

        while (node.next != null && node.next.next != null) {
            ListNode prev = node;
            ListNode curNode = prev.next;

            ListNode temp = curNode.next;
            curNode.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;

            node = curNode;
        }

        return dummyNode.next;
    }
}
