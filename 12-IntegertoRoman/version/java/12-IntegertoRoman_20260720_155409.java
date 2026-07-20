// Last updated: 20/07/2026, 15:54:09
1class Solution {
2    public String intToRoman(int num) {
3        // Values and their corresponding Roman symbols arranged in descending order
4        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
5        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
6        
7        StringBuilder roman = new StringBuilder();
8        
9        // Loop through the values array
10        for (int i = 0; i < values.length; i++) {
11            // Repeat the symbol while the current value fits into num
12            while (num >= values[i]) {
13                roman.append(symbols[i]);
14                num -= values[i];
15            }
16        }
17        
18        return roman.toString();
19    }
20}