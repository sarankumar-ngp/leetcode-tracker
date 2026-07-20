// Last updated: 20/07/2026, 15:05:35
1class Solution {
2    public boolean isPalindrome(String s) {
3        if (s == null) {
4            return false;
5        }
6
7        int left = 0;
8        int right = s.length() - 1;
9
10        while (left < right) {
11            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
12                left++;
13            }
14            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
15                right--;
16            }
17
18            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
19                return false;
20            }
21
22            left++;
23            right--;
24        }
25
26        return true;
27    }
28}