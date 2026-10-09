// Last updated: 09/10/2026, 09:09:39
1class Solution {
2    public int uniquePaths(int m, int n) {
3        int[][] dp = new int[m][n];
4        for (int j = 0; j < n; j++) {
5            dp[0][j] = 1;
6        }
7        for (int i = 0; i < m; i++) {
8            dp[i][0] = 1;
9        }
10        for (int i = 1; i < m; i++) {
11            for (int j = 1; j < n; j++) {
12                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
13            }
14        }
15
16        return dp[m - 1][n - 1];
17    }
18}