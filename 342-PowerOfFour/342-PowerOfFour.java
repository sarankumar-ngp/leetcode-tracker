// Last updated: 28/07/2026, 15:43:12
class Solution {
    public boolean isPowerOfFour(int n) {
        // 1. n > 0: must be positive
        // 2. (n & (n - 1)) == 0: checks if it's a power of two
        // 3. (n & 0x55555555) != 0: ensures the set bit is at an even index (0, 2, 4, etc.)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}