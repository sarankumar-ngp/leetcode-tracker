// Last updated: 09/10/2026, 09:25:13
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
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to act as the sub-chain anchor before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Track the node immediately preceding the pair to be swapped
        ListNode prev = dummy;
        
        // Loop runs as long as there is a pair left to swap
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Adjust pointers to execute the swap
            first.next = second.next;
            second.next = first;
            prev.next = second;
            
            // Move prev forward by two nodes for the next pair execution
            prev = first;
        }
        
        return dummy.next;
    }
}