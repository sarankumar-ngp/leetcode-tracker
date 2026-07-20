// Last updated: 20/07/2026, 16:07:48
1class Solution {
2    public int divide(int dividend, int divisor) {
3        // Special edge case handling for 32-bit overflow
4        if (dividend == Integer.MIN_VALUE && divisor == -1) {
5            return Integer.MAX_VALUE;
6        }
7
8        // Determine the sign of the final quotient
9        boolean isNegative = (dividend < 0) ^ (divisor < 0);
10
11        // Convert to long and take absolute values to safely prevent overflow and wrap-around
12        long absDividend = Math.abs((long) dividend);
13        long absDivisor = Math.abs((long) divisor);
14
15        long quotient = 0;
16
17        // Perform binary long division
18        for (int shift = 31; shift >= 0; shift--) {
19            if ((absDivisor << shift) <= absDividend) {
20                absDividend -= (absDivisor << shift);
21                quotient |= (1L << shift);
22            }
23        }
24
25        return isNegative ? (int) -quotient : (int) quotient;
26    }
27}