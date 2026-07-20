// Last updated: 20/07/2026, 15:44:01
1class Solution {
2    public int[] countBits(int n) {
3        int[] ans = new int[n + 1];
4        
5        for (int i = 1; i <= n; i++) {
6            // i >> 1 is equivalent to i / 2
7            // i & 1 checks if the number is odd (adds 1 if true, 0 if false)
8            ans[i] = ans[i >> 1] + (i & 1);
9        }
10        
11        return ans;
12    }
13}