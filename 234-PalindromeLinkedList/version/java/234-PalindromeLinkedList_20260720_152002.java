// Last updated: 20/07/2026, 15:20:02
1
2class Solution {
3    public boolean isPalindrome(ListNode head) {
4        if (head == null || head.next == null) {
5            return true;
6        }
7
8        ListNode slow = head;
9        ListNode fast = head;
10        while (fast != null && fast.next != null) {
11            slow = slow.next;
12            fast = fast.next.next;
13        }
14        ListNode secondHalfHead = reverseList(slow);
15        ListNode firstHalfHead = head;
16
17        ListNode p1 = firstHalfHead;
18        ListNode p2 = secondHalfHead;
19        boolean isPalin = true;
20        
21        while (p2 != null) {
22            if (p1.val != p2.val) {
23                isPalin = false;
24                break;
25            }
26            p1 = p1.next;
27            p2 = p2.next;
28        }
29
30        reverseList(secondHalfHead);
31
32        return isPalin;
33    }
34
35    private ListNode reverseList(ListNode head) {
36        ListNode prev = null;
37        ListNode curr = head;
38        while (curr != null) {
39            ListNode nextNode = curr.next;
40            curr.next = prev;
41            prev = curr;
42            curr = nextNode;
43        }
44        return prev;
45    }
46}