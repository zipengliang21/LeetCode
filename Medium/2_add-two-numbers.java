package Medium;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode head = dummyNode;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int sum = num1 + num2 + carry;
            int value = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(value);
            head.next = newNode;
            head = head.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
