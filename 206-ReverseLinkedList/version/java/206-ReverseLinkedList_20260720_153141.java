// Last updated: 20/07/2026, 15:31:41
1class Solution {
2    public ListNode reverseList(ListNode head) {
3        ListNode prev = null;
4        ListNode curr = head;
5        
6        while (curr != null) {
7            ListNode next = curr.next; // Store the next node
8            curr.next = prev;          // Reverse the current node's pointer
9            prev = curr;               // Move prev one step forward
10            curr = next;               // Move curr one step forward
11        }
12        
13        return prev; // prev will be the new head of the reversed list
14    }
15}