// Last updated: 20/07/2026, 16:02:55
1import java.util.PriorityQueue;
2
3/**
4 * Definition for singly-linked list.
5 * public class ListNode {
6 *     int val;
7 *     ListNode next;
8 *     ListNode() {}
9 *     ListNode(int val) { this.val = val; }
10 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
11 * }
12 */
13class Solution {
14    public ListNode mergeKLists(ListNode[] lists) {
15        if (lists == null || lists.length == 0) {
16            return null;
17        }
18
19        // Initialize a Min-Heap based on the values of the ListNodes
20        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
21
22        // Add the head node of each non-empty linked list to the heap
23        for (ListNode root : lists) {
24            if (root != null) {
25                minHeap.offer(root);
26            }
27        }
28
29        ListNode dummy = new ListNode(0);
30        ListNode current = dummy;
31
32        // Process the heap until all nodes are merged
33        while (!minHeap.isEmpty()) {
34            ListNode smallestNode = minHeap.poll();
35            current.next = smallestNode;
36            current = current.next;
37
38            // If the extracted node has a next element, push it into the heap
39            if (smallestNode.next != null) {
40                minHeap.offer(smallestNode.next);
41            }
42        }
43
44        return dummy.next;
45    }
46}