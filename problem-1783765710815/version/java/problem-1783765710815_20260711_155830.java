// Last updated: 11/07/2026, 15:58:30
1class Solution {
2    public String addBinary(String a, String b) {
3
4        StringBuilder result = new StringBuilder();
5
6        int i = a.length() - 1;
7        int j = b.length() - 1;
8        int carry = 0;
9
10        while (i >= 0 || j >= 0 || carry != 0) {
11
12            int sum = carry;
13
14            if (i >= 0) {
15                sum += a.charAt(i) - '0';
16                i--;
17            }
18
19            if (j >= 0) {
20                sum += b.charAt(j) - '0';
21                j--;
22            }
23
24            result.append(sum % 2);
25            carry = sum / 2;
26        }
27
28        return result.reverse().toString();
29    }
30}