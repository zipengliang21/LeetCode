/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
const reverseList = (head) => {
    let pre = null;
    let current = head;

    while (current != null) {
        let next = current.next;
        current.next = pre;
        pre = current;
        current = next;
    }

    return pre;
};