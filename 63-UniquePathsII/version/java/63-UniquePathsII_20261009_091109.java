// Last updated: 09/10/2026, 09:11:09
1
2class Solution {
3    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
4        int m = obstacleGrid.length;
5        int n = obstacleGrid[0].length;
6        int[][] dp = new int[m][n];
7        if (obstacleGrid[0][0] == 1) {
8            return 0;
9        }
10        dp[0][0] = 1;
11
12        for (int i = 0; i < m; i++) {
13            for (int j = 0; j < n; j++) {
14                if (obstacleGrid[i][j] == 1) {
15                    dp[i][j] = 0;
16                    continue;
17                }
18                if (i > 0) {
19                    dp[i][j] += dp[i - 1][j];
20                }
21                if (j > 0) {
22                    dp[i][j] += dp[i][j - 1];
23                }
24            }
25        }
26
27        return dp[m - 1][n - 1];
28    }
29}