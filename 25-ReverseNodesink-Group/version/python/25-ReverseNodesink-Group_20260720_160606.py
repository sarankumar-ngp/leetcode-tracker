# Last updated: 20/07/2026, 16:06:06
1# Definition for singly-linked list.
2# class ListNode:
3#     def __init__(self, val=0, next=None):
4#         self.val = val
5#         self.next = next
6
7class Solution:
8    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
9        if not head or k == 1:
10            return head
11        
12        dummy = ListNode(0)
13        dummy.next = head
14        pointer_group_prev = dummy
15        
16        while True:
17            # Check if there are at least k nodes available to reverse
18            kth_node = self.getKthNode(pointer_group_prev, k)
19            if not kth_node:
20                break
21                
22            pointer_group_next = kth_node.next
23            
24            # Reverse the current k-group segment
25            prev = kth_node.next  # Connect tail of reversed sub-list to the next section
26            curr = pointer_group_prev.next
27            
28            while curr != pointer_group_next:
29                next_node = curr.next
30                curr.next = prev
31                prev = curr
32                curr = next_node
33            
34            # Re-anchor the previous sub-list segment tail to the new reversed head
35            temp = pointer_group_prev.next
36            pointer_group_prev.next = kth_node
37            pointer_group_prev = temp
38            
39        return dummy.next
40
41    def getKthNode(self, curr: Optional[ListNode], k: int) -> Optional[ListNode]:
42        while curr and k > 0:
43            curr = curr.next
44            k -= 1
45        return curr