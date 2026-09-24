// Last updated: 24/09/2026, 09:10:06
1class Solution {
2    public String multiply(String num1, String num2) {
3
4        if (num1.equals("0") || num2.equals("0")) {
5            return "0";
6        }
7
8        int n = num1.length();
9        int m = num2.length();
10
11        int[] result = new int[n + m];
12
13        for (int i = n - 1; i >= 0; i--) {
14
15            for (int j = m - 1; j >= 0; j--) {
16
17                int digit1 = num1.charAt(i) - '0';
18                int digit2 = num2.charAt(j) - '0';
19
20                int product = digit1 * digit2;
21
22                int pos1 = i + j;
23                int pos2 = i + j + 1;
24
25                int sum = product + result[pos2];
26
27                result[pos2] = sum % 10;
28                result[pos1] += sum / 10;
29            }
30        }
31
32        StringBuilder ans = new StringBuilder();
33
34        for (int digit : result) {
35
36            if (ans.length() == 0 && digit == 0) {
37                continue;
38            }
39
40            ans.append(digit);
41        }
42
43        return ans.toString();
44    }
45}