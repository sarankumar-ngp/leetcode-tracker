// Last updated: 20/07/2026, 15:15:15
1public class Solution {
2
3    public int reverseBits(int n) {
4        int result = 0;
5        
6        for (int i = 0; i < 32; i++) {
7
8            result <<= 1;
9            
10           
11            result |= (n & 1);
12            
13          
14            n >>>= 1;
15        }
16        
17        return result;
18    }
19}