// Last updated: 11/07/2026, 15:53:09
1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3
4        if (strs == null || strs.length == 0) {
5            return "";
6        }
7
8        String prefix = strs[0];
9
10        for (int i = 1; i < strs.length; i++) {
11
12            while (!strs[i].startsWith(prefix)) {
13                prefix = prefix.substring(0, prefix.length() - 1);
14
15                if (prefix.isEmpty()) {
16                    return "";
17                }
18            }
19        }
20
21        return prefix;
22    }
23}