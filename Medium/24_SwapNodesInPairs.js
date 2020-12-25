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
 * Basically, need a pointer point to current head and do the swap.
 * Then, move the pointer forward
 */
let swapPairs = function (head) {
    if (head === null || (head !== null && head.next === null)) return head;
    let current = head;
    let next = head.next;
    head.next = next.next;
    next.next = current;
    current = head;
    let result = next;
    while (current.next !== null && current.next.next !== null) {
        let nextHead = current.next;
        next = nextHead.next;
        nextHead.next = next.next;
        next.next = nextHead;
        current.next = next;
        current = nextHead;
    }
    return result;
};