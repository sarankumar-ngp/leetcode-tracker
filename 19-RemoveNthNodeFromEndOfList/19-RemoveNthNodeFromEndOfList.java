// Last updated: 09/10/2026, 09:25:18
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node that points to the head to simplify edge cases (like removing the head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move the fast pointer n + 1 steps ahead so that a gap of n nodes is created between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers forward until the fast pointer reaches the end of the list
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Relink the slow pointer's next to skip the target nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}