// Last updated: 09/10/2026, 09:24:38
class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;

        // 1. Left-to-right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            
            // When open and close parentheses balance out, we have a valid substring
            if (left == right) {
                maxLength = Math.max(maxLength, 2 * right);
            } 
            // If close parentheses exceed open ones, the current segment is permanently invalid
            else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        // 2. Right-to-left pass (to catch cases like "(()")
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLength = Math.max(maxLength, 2 * left);
            } 
            // If open parentheses exceed close ones, reset tracking
            else if (left > right) {
                left = right = 0;
            }
        }

        return maxLength;
    }
}