// Last updated: 20/07/2026, 15:10:02
1public class Solution {
2    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
3        if (headA == null || headB == null) {
4            return null;
5        }
6
7        ListNode pA = headA;
8        ListNode pB = headB;
9
10
11        while (pA != pB) {
12
13            pA = (pA == null) ? headB : pA.next;
14         
15            pB = (pB == null) ? headA : pB.next;
16        }
17
18        return pA;
19    }
20}