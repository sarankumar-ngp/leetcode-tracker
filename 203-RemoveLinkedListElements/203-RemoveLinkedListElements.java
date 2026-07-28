// Last updated: 28/07/2026, 15:43:47
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
    public ListNode removeElements(ListNode head, int val) {
        // Create a sentinel node pointing to the head
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        
        ListNode prev = sentinel;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node by linking the previous node to current's next
                prev.next = curr.next;
            } else {
                // Move the previous pointer forward only if we didn't delete a node
                prev = curr;
            }
            // Advance the current pointer
            curr = curr.next;
        }
        
        // Return the actual head, which is sentinel's next
        return sentinel.next;
    }
}