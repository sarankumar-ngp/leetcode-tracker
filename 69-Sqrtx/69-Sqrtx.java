// Last updated: 09/07/2026, 10:14:11
class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;
        int ans = 0;

        while (left <= right) {
            int m = left + (right - left) / 2;

            if ((long) m * m == x) {
                return m;
            } else if ((long) m * m < x) {
                ans = m;
                left = m + 1;
            } else {
                right = m - 1;
            }
        }

        return ans;
    }
}