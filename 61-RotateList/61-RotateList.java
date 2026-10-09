// Last updated: 09/10/2026, 09:23:43

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        temp.next = head;
        k = k % length;

        int steps = length - k;
        ListNode newLast = head;

        for (int i = 1; i < steps; i++) {
            newLast = newLast.next;
        }
        ListNode newHead = newLast.next;
        newLast.next = null;

        return newHead;
    }
}