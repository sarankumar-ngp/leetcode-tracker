// Last updated: 09/10/2026, 09:23:48
class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        // Store 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Calculate factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Convert k to 0-based index
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {

            int blockSize = fact[i - 1];

            int index = k / blockSize;

            result.append(numbers.get(index));

            numbers.remove(index);

            k = k % blockSize;
        }

        return result.toString();
    }
}