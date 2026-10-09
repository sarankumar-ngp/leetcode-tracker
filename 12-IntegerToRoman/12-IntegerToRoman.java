// Last updated: 09/10/2026, 09:25:43
class Solution {
    public String intToRoman(int num) {
        // Values and their corresponding Roman symbols arranged in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Loop through the values array
        for (int i = 0; i < values.length; i++) {
            // Repeat the symbol while the current value fits into num
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return roman.toString();
    }
}