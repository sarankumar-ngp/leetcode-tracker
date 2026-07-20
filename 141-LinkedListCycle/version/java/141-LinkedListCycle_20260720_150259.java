// Last updated: 20/07/2026, 15:02:59
1public class Solution {
2    public boolean hasCycle(ListNode head) {
3        if (head == null || head.next == null) {
4            return false;
5        }
6
7        ListNode slow = head;
8        ListNode fast = head;
9
10        while (fast != null && fast.next != null) {
11            slow = slow.next;   
12            fast = fast.next.next;   
13
14            if (slow == fast) {
15                return true;
16            }
17        }
18        return false;
19    }
20}