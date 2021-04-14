/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
let ref;

const isPalindrome = function (head) {
    ref = head;
    return check(head);
};

const check = (node) => {
    if (node === null) return true;

    if (check(node.next) && ref.val === node.val) {
        ref = ref.next;
        return true;
    } else {
        return false;
    }

}