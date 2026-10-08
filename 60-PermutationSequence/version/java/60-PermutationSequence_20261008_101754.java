// Last updated: 08/10/2026, 10:17:54
1class Solution {
2    public String getPermutation(int n, int k) {
3
4        List<Integer> numbers = new ArrayList<>();
5
6        // Store 1 to n
7        for (int i = 1; i <= n; i++) {
8            numbers.add(i);
9        }
10
11        // Calculate factorials
12        int[] fact = new int[n + 1];
13        fact[0] = 1;
14
15        for (int i = 1; i <= n; i++) {
16            fact[i] = fact[i - 1] * i;
17        }
18
19        // Convert k to 0-based index
20        k--;
21
22        StringBuilder result = new StringBuilder();
23
24        for (int i = n; i >= 1; i--) {
25
26            int blockSize = fact[i - 1];
27
28            int index = k / blockSize;
29
30            result.append(numbers.get(index));
31
32            numbers.remove(index);
33
34            k = k % blockSize;
35        }
36
37        return result.toString();
38    }
39}