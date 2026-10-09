// Last updated: 09/10/2026, 09:23:18

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }
        
        ListNode current = head;
        
        while (current != null && current.next != null) {
           
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
}