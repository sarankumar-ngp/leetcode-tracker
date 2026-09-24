// Last updated: 24/09/2026, 09:08:50
1class Solution {
2    public String multiply(String num1, String num2) {
3
4        // If either number is 0
5        if (num1.equals("0") || num2.equals("0")) {
6            return "0";
7        }
8
9        int n = num1.length();
10        int m = num2.length();
11
12        // Maximum possible length
13        int[] result = new int[n + m];
14
15        // Multiply each digit
16        for (int i = n - 1; i >= 0; i--) {
17
18            for (int j = m - 1; j >= 0; j--) {
19
20                int digit1 = num1.charAt(i) - '0';
21                int digit2 = num2.charAt(j) - '0';
22
23                int product = digit1 * digit2;
24
25                int pos1 = i + j;
26                int pos2 = i + j + 1;
27
28                int sum = product + result[pos2];
29
30                result[pos2] = sum % 10;
31                result[pos1] += sum / 10;
32            }
33        }
34
35        // Convert array to String
36        StringBuilder ans = new StringBuilder();
37
38        for (int digit : result) {
39
40            // Skip leading zeros
41            if (ans.length() == 0 && digit == 0) {
42                continue;
43            }
44
45            ans.append(digit);
46        }
47
48        return ans.toString();
49    }
50}