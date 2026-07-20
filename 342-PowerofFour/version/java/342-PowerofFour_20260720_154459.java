// Last updated: 20/07/2026, 15:44:59
1class Solution {
2    public boolean isPowerOfFour(int n) {
3        // 1. n > 0: must be positive
4        // 2. (n & (n - 1)) == 0: checks if it's a power of two
5        // 3. (n & 0x55555555) != 0: ensures the set bit is at an even index (0, 2, 4, etc.)
6        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
7    }
8}