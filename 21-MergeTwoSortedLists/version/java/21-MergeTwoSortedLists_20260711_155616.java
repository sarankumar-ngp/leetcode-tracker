// Last updated: 11/07/2026, 15:56:16
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
16    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
17
18        ListNode dummy = new ListNode(-1);
19        ListNode current = dummy;
20
21        while (list1 != null && list2 != null) {
22
23            if (list1.val <= list2.val) {
24                current.next = list1;
25                list1 = list1.next;
26            } else {
27                current.next = list2;
28                list2 = list2.next;
29            }
30
31            current = current.next;
32        }
33
34        if (list1 != null) {
35            current.next = list1;
36        }
37
38        if (list2 != null) {
39            current.next = list2;
40        }
41
42        return dummy.next;
43    }
44}