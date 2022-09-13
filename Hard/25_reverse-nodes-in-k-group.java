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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode node = dummyNode;

        while (node != null && node.next != null) {
            ListNode prev = node;
            ListNode check = node;

            for (int i = 0; i < k; i++) {
                if (check.next == null) {
                    return dummyNode.next;
                }

                check = check.next;
            }

            ListNode curNode = prev.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = curNode.next;
                curNode.next = temp.next;
                temp.next = prev.next;
                prev.next = temp;
            }

            node = curNode;
        }

        return dummyNode.next;
    }
}