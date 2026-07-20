// Last updated: 20/07/2026, 15:13:08
1class Solution {
2    public int titleToNumber(String columnTitle) {
3        int result = 0;
4        
5        for (int i = 0; i < columnTitle.length(); i++) {
6            char c = columnTitle.charAt(i);
7            result = result * 26 + (c - 'A' + 1);
8        }
9        
10        return result;
11    }
12}