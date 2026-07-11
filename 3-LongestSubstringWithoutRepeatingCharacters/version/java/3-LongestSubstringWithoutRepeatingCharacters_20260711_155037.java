// Last updated: 11/07/2026, 15:50:37
1import java.util.HashSet;
2
3class Solution {
4    public int lengthOfLongestSubstring(String s) {
5
6        HashSet<Character> set = new HashSet<>();
7
8        int left = 0;
9        int maxLength = 0;
10
11        for (int right = 0; right < s.length(); right++) {
12
13            while (set.contains(s.charAt(right))) {
14                set.remove(s.charAt(left));
15                left++;
16            }
17
18            set.add(s.charAt(right));
19            maxLength = Math.max(maxLength, right - left + 1);
20        }
21
22        return maxLength;
23    }
24}