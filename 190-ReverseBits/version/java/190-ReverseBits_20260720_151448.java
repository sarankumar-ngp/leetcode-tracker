// Last updated: 20/07/2026, 15:14:48
1public class Solution {
2    // you need treat n as an unsigned value
3    public int reverseBits(int n) {
4        int result = 0;
5        
6        for (int i = 0; i < 32; i++) {
7            // Shift result left to make room for the next bit
8            result <<= 1;
9            
10            // Extract the least significant bit of n and add it to result
11            result |= (n & 1);
12            
13            // Unsigned right shift n by 1 to process the next bit
14            n >>>= 1;
15        }
16        
17        return result;
18    }
19}