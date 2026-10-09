// Last updated: 09/10/2026, 09:13:29
1
2class Solution {
3    public int minPathSum(int[][] grid) {
4        int m = grid.length;
5        int n = grid[0].length;
6
7        int[][] dp = new int[m][n];
8
9        dp[0][0] = grid[0][0];
10
11        for (int j = 1; j < n; j++) {
12            dp[0][j] = dp[0][j - 1] + grid[0][j];
13        }
14
15        for (int i = 1; i < m; i++) {
16            dp[i][0] = dp[i - 1][0] + grid[i][0];
17        }
18
19        for (int i = 1; i < m; i++) {
20            for (int j = 1; j < n; j++) {
21                dp[i][j] = grid[i][j]
22                         + Math.min(dp[i - 1][j], dp[i][j - 1]);
23            }
24        }
25
26        return dp[m - 1][n - 1];
27    }
28}