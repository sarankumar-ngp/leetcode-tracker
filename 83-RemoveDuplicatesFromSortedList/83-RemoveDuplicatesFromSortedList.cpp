// Last updated: 09/10/2026, 09:23:23

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {

        if (!head) return nullptr;
        
        ListNode* current = head;
        
        while (current && current->next) {
            if (current->val == current->next->val) {
                ListNode* duplicate = current->next;
                current->next = current->next->next;
                delete duplicate; 
            } else {
                current = current->next;
            }
        }
        
        return head;
    }
};