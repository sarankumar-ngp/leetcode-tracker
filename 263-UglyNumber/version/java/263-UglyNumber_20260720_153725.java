// Last updated: 20/07/2026, 15:37:25
1class Solution {
2    public boolean isUgly(int n) {
3        // Edge case: Any number less than or equal to 0 cannot be an ugly number
4        if (n <= 0) {
5            return false;
6        }
7
8        // Divide by 2, 3, and 5 as much as possible
9        int[] primes = {2, 3, 5};
10        for (int prime : primes) {
11            while (n % prime == 0) {
12                n /= prime;
13            }
14        }
15
16        // If n reduces to 1, it means it has no other prime factors
17        return n == 1;
18    }
19}
20