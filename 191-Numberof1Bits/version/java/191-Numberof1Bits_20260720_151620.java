// Last updated: 20/07/2026, 15:16:20
1class Solution {
2    public int hammingWeight(int n) {
3        int count = 0;
4        
5        while (n != 0) {
6        
7            n = n & (n - 1);
8            count++;
9        }
10        
11        return count;
12    }
13}