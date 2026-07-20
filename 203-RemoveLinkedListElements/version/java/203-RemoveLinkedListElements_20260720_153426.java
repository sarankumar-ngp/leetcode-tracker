// Last updated: 20/07/2026, 15:34:26
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeElements(ListNode head, int val) {
13        // Create a sentinel node pointing to the head
14        ListNode sentinel = new ListNode(0);
15        sentinel.next = head;
16        
17        ListNode prev = sentinel;
18        ListNode curr = head;
19        
20        while (curr != null) {
21            if (curr.val == val) {
22                // Skip the current node by linking the previous node to current's next
23                prev.next = curr.next;
24            } else {
25                // Move the previous pointer forward only if we didn't delete a node
26                prev = curr;
27            }
28            // Advance the current pointer
29            curr = curr.next;
30        }
31        
32        // Return the actual head, which is sentinel's next
33        return sentinel.next;
34    }
35}