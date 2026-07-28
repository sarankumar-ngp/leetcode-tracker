// Last updated: 28/07/2026, 15:43:14
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // i >> 1 is equivalent to i / 2
            // i & 1 checks if the number is odd (adds 1 if true, 0 if false)
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}