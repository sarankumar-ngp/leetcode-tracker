// Last updated: 09/10/2026, 09:25:03
import java.util.PriorityQueue;

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

        // Initialize a Min-Heap based on the values of the ListNodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head node of each non-empty linked list to the heap
        for (ListNode root : lists) {
            if (root != null) {
                minHeap.offer(root);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Process the heap until all nodes are merged
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode;
            current = current.next;

            // If the extracted node has a next element, push it into the heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummy.next;
    }
}