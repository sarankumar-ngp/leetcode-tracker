// Last updated: 09/10/2026, 09:24:46
class Solution {
    public int divide(int dividend, int divisor) {
        // Special edge case handling for 32-bit overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the final quotient
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and take absolute values to safely prevent overflow and wrap-around
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        long quotient = 0;

        // Perform binary long division
        for (int shift = 31; shift >= 0; shift--) {
            if ((absDivisor << shift) <= absDividend) {
                absDividend -= (absDivisor << shift);
                quotient |= (1L << shift);
            }
        }

        return isNegative ? (int) -quotient : (int) quotient;
    }
}