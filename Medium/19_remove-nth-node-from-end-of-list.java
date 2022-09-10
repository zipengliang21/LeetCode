package Medium;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode first = dummyNode;
        ListNode second = dummyNode;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummyNode.next;
    }
}