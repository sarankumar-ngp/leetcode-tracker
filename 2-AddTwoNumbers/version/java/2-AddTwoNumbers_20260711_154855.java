// Last updated: 11/07/2026, 15:48:55
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) {
9 *         this.val = val;
10 *         this.next = next;
11 *     }
12 * }
13 */
14
15class Solution {
16    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
17
18        ListNode dummy = new ListNode(0);
19        ListNode current = dummy;
20
21        int carry = 0;
22
23        while (l1 != null || l2 != null || carry != 0) {
24
25            int x = (l1 != null) ? l1.val : 0;
26            int y = (l2 != null) ? l2.val : 0;
27
28            int sum = x + y + carry;
29            carry = sum / 10;
30
31            current.next = new ListNode(sum % 10);
32            current = current.next;
33
34            if (l1 != null) l1 = l1.next;
35            if (l2 != null) l2 = l2.next;
36        }
37
38        return dummy.next;
39    }
40}