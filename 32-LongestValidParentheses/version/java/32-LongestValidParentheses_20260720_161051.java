// Last updated: 20/07/2026, 16:10:51
1class Solution {
2    public int longestValidParentheses(String s) {
3        int left = 0, right = 0, maxLength = 0;
4
5        // 1. Left-to-right pass
6        for (int i = 0; i < s.length(); i++) {
7            if (s.charAt(i) == '(') {
8                left++;
9            } else {
10                right++;
11            }
12            
13            // When open and close parentheses balance out, we have a valid substring
14            if (left == right) {
15                maxLength = Math.max(maxLength, 2 * right);
16            } 
17            // If close parentheses exceed open ones, the current segment is permanently invalid
18            else if (right > left) {
19                left = right = 0;
20            }
21        }
22
23        left = right = 0;
24
25        // 2. Right-to-left pass (to catch cases like "(()")
26        for (int i = s.length() - 1; i >= 0; i--) {
27            if (s.charAt(i) == '(') {
28                left++;
29            } else {
30                right++;
31            }
32
33            if (left == right) {
34                maxLength = Math.max(maxLength, 2 * left);
35            } 
36            // If open parentheses exceed close ones, reset tracking
37            else if (left > right) {
38                left = right = 0;
39            }
40        }
41
42        return maxLength;
43    }
44}