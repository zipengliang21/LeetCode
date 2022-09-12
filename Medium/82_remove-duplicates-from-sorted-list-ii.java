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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode node = dummyNode;

        while (node != null && node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                int value = node.next.val;

                while (node.next != null && node.next.val == value) {
                    node.next = node.next.next;
                }
            } else {
                node = node.next;
            }
        }

        return dummyNode.next;
    }
}
