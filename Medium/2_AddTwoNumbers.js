/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
const addTwoNumbers = function (l1, l2) {
    let dummyHead = new ListNode(0, null);
    let temp = dummyHead;

    let i = l1;
    let j = l2;
    let carry = 0;

    while (i || j) {
        const x = i ? i.val : 0;
        const y = j ? j.val : 0;

        const sum = x + y + carry;

        temp.next = new ListNode(sum % 10, null);
        temp = temp.next;
        carry = Math.floor(sum / 10);

        i = i ? i.next : null;
        j = j ? j.next : null;
    }

    if (carry >= 1) {
        temp.next = new ListNode(carry, null);
    }

    return dummyHead.next;
};