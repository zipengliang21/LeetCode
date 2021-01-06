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
const deleteDuplicates = (head) => {
    let result = new ListNode(0);
    result.next = head;
    let prePointer = result;
    let pointer = head;
    while (pointer && pointer.next) {
        const potentialDuplicate = pointer.val;
        const count = countDuplicate(pointer, potentialDuplicate);
        // move pointer
        for (let i = 0; i < count; i++) {
            pointer = pointer.next;
        }

        // handle prePointer and result correspondingly
        if (count === 1) {
            prePointer = prePointer.next;
        } else {
            if (result === prePointer) {
                result.next = pointer;
            }
            prePointer.next = pointer;
        }
    }
    return result.next;
};

/**
 * 
 * @param {ListNode} current current node
 * @param {number} value the value of current node
 * count the number of node which has the given duplicate value
 * Note: Only count > 1 means there's duplicate nodes
 */
const countDuplicate = (current, value) => {
    let count = 0;
    while (current !== null && current.val === value) {
        count++;
        current = current.next;
    }
    return count;
}
