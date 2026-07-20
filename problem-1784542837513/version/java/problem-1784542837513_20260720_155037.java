// Last updated: 20/07/2026, 15:50:37
1class Solution {
2    public int myAtoi(String s) {
3        if (s == null || s.length() == 0) {
4            return 0;
5        }
6
7        int index = 0;
8        int n = s.length();
9
10        // 1. Skip leading whitespace
11        while (index < n && s.charAt(index) == ' ') {
12            index++;
13        }
14
15        // Check if string is empty after whitespaces
16        if (index == n) {
17            return 0;
18        }
19
20        // 2. Determine the sign
21        int sign = 1;
22        char firstChar = s.charAt(index);
23        if (firstChar == '+') {
24            index++;
25        } else if (firstChar == '-') {
26            sign = -1;
27            index++;
28        }
29
30        // 3. Convert characters to integer and handle rounding/overflow
31        int result = 0;
32        while (index < n) {
33            char c = s.charAt(index);
34            // Stop parsing if a non-digit character is encountered
35            if (c < '0' || c > '9') {
36                break;
37            }
38
39            int digit = c - '0';
40
41            // Check overflow before updating result
42            // Integer.MAX_VALUE is 2147483647. Integer.MAX_VALUE / 10 is 214748364.
43            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
44                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
45            }
46
47            result = result * 10 + digit;
48            index++;
49        }
50
51        return result * sign;
52    }
53}