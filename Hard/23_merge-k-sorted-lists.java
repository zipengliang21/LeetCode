/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // build the min heap with size k
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, (node1, node2) -> node1.val - node2.val);

        // put each head node of the linked list into the heap, maintain the min heap property
        for (ListNode node: lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;

        // while heap is not empty
        while (!heap.isEmpty()) {
            ListNode minNode = heap.poll();

            node.next = minNode;
            node = minNode;

            // if the current heap element has next node, put it into the heap
            if (minNode.next != null) {
                heap.offer(minNode.next);
            }
        }

        return dummyNode.next;
    }
}