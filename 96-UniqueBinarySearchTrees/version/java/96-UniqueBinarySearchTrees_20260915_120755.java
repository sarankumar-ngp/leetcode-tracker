// Last updated: 15/09/2026, 12:07:55
1class Solution {
2    public int numTrees(int n) {
3
4        int[] dp = new int[n + 1];
5
6        dp[0] = 1;
7        dp[1] = 1;
8
9        for (int i = 2; i <= n; i++) {
10
11            for (int root = 1; root <= i; root++) {
12
13                int left = root - 1;
14                int right = i - root;
15
16                dp[i] += dp[left] * dp[right];
17            }
18        }
19
20        return dp[n];
21    }
22}