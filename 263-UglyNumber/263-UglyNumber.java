// Last updated: 28/07/2026, 15:43:24
class Solution {
    public boolean isUgly(int n) {
        // Edge case: Any number less than or equal to 0 cannot be an ugly number
        if (n <= 0) {
            return false;
        }

        // Divide by 2, 3, and 5 as much as possible
        int[] primes = {2, 3, 5};
        for (int prime : primes) {
            while (n % prime == 0) {
                n /= prime;
            }
        }

        // If n reduces to 1, it means it has no other prime factors
        return n == 1;
    }
}
