// Last updated: 09/10/2026, 09:08:00
1
2class Solution {
3    public ListNode rotateRight(ListNode head, int k) {
4        if (head == null || head.next == null || k == 0) {
5            return head;
6        }
7        ListNode temp = head;
8        int length = 1;
9        while (temp.next != null) {
10            temp = temp.next;
11            length++;
12        }
13        temp.next = head;
14        k = k % length;
15
16        int steps = length - k;
17        ListNode newLast = head;
18
19        for (int i = 1; i < steps; i++) {
20            newLast = newLast.next;
21        }
22        ListNode newHead = newLast.next;
23        newLast.next = null;
24
25        return newHead;
26    }
27}