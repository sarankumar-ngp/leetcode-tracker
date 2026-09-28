// Last updated: 28/09/2026, 09:49:44
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int sIdx = 0, pIdx = 0;
4        int starIdx = -1, sTmpIdx = -1;
5
6        while (sIdx < s.length()) {
7            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
8                sIdx++;
9                pIdx++;
10            } 
11            else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
12                starIdx = pIdx;
13                sTmpIdx = sIdx;
14                pIdx++; 
15            } 
16            else if (starIdx != -1) {
17                pIdx = starIdx + 1;
18                sTmpIdx++;
19                sIdx = sTmpIdx;
20            } 
21            else {
22                return false;
23            }
24        }
25        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
26            pIdx++;
27        }
28
29        return pIdx == p.length();
30    }
31}