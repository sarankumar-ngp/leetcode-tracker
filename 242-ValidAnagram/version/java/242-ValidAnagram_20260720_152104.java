// Last updated: 20/07/2026, 15:21:04
1class Solution {
2    public boolean isAnagram(String s, String t) {
3        // If lengths are different, they cannot be anagrams
4        if (s.length() != t.length()) {
5            return false;
6        }
7
8        // An array to store character counts for 'a' through 'z'
9        int[] charCounts = new int[26];
10
11        for (int i = 0; i < s.length(); i++) {
12            charCounts[s.charAt(i) - 'a']++;
13            charCounts[t.charAt(i) - 'a']--;
14        }
15
16        // Check if all counts are zero
17        for (int count : charCounts) {
18            if (count != 0) {
19                return false;
20            }
21        }
22
23        return true;
24    }
25}