// Last updated: 09/10/2026, 09:25:54
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();

        // 1. Skip leading whitespace
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Check if string is empty after whitespaces
        if (index == n) {
            return 0;
        }

        // 2. Determine the sign
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }

        // 3. Convert characters to integer and handle rounding/overflow
        int result = 0;
        while (index < n) {
            char c = s.charAt(index);
            // Stop parsing if a non-digit character is encountered
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';

            // Check overflow before updating result
            // Integer.MAX_VALUE is 2147483647. Integer.MAX_VALUE / 10 is 214748364.
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}