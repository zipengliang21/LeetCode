/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
const hasCycle = function (head) {
    const seen = new Map();

    while (head) {
        if (!seen.get(head)) {
            seen.set(head, true);
        } else {
            return true;
        }
        head = head.next;
    }

    return false;
};

var hasCycle = function (head) {
    let nodesSeen = new Set()
    while (head != null) {
        if (nodesSeen.has(head)) {
            return true;
        }
        else {
            nodesSeen.add(head)
        }
        head = head.next
    }
    return false
};

const hasCycle = function (head) {
    if (!head) {
        return false;
    }

    let slow = head;
    let fast = head.next;

    while (slow !== fast) {
        if (fast === null || fast.next === null) {
            return false;
        }

        slow = slow.next;
        fast = fast.next.next;
    }

    return true;
};