// Last updated: 20/07/2026, 15:11:05
1class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder title = new StringBuilder();
4
5        while (columnNumber > 0) {
6            columnNumber--;
7            
8            int remainder = columnNumber % 26;
9            title.append((char) ('A' + remainder));
10            
11            columnNumber /= 26;
12        }
13
14        return title.reverse().toString();
15    }
16}