// Last updated: 20/07/2026, 15:48:38
1class Solution {
2    public String longestPalindrome(String s) {
3        if (s == null || s.length() < 1) return "";
4        
5        int start = 0;
6        int end = 0;
7        
8        for (int i = 0; i < s.length(); i++) {
9            // Case 1: Odd length palindrome (e.g., "aba", center is 'b')
10            int len1 = expandAroundCenter(s, i, i);
11            
12            // Case 2: Even length palindrome (e.g., "abba", center is between 'b' and 'b')
13            int len2 = expandAroundCenter(s, i, i + 1);
14            
15            int maxLen = Math.max(len1, len2);
16            
17            // If we found a longer palindrome, update the start and end boundaries
18            if (maxLen > (end - start)) {
19                start = i - (maxLen - 1) / 2;
20                end = i + maxLen / 2;
21            }
22        }
23        
24        return s.substring(start, end + 1);
25    }
26    
27    private int expandAroundCenter(String s, int left, int right) {
28        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
29            left--;
30            right++;
31        }
32        // Returns the length of the palindrome found
33        return right - left - 1;
34    }
35}