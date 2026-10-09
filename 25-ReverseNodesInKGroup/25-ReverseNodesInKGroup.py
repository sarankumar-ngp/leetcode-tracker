# Last updated: 09/10/2026, 09:24:59
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k == 1:
            return head
        
        dummy = ListNode(0)
        dummy.next = head
        pointer_group_prev = dummy
        
        while True:
            # Check if there are at least k nodes available to reverse
            kth_node = self.getKthNode(pointer_group_prev, k)
            if not kth_node:
                break
                
            pointer_group_next = kth_node.next
            
            # Reverse the current k-group segment
            prev = kth_node.next  # Connect tail of reversed sub-list to the next section
            curr = pointer_group_prev.next
            
            while curr != pointer_group_next:
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node
            
            # Re-anchor the previous sub-list segment tail to the new reversed head
            temp = pointer_group_prev.next
            pointer_group_prev.next = kth_node
            pointer_group_prev = temp
            
        return dummy.next

    def getKthNode(self, curr: Optional[ListNode], k: int) -> Optional[ListNode]:
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr