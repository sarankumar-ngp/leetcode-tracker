// Last updated: 09/10/2026, 09:26:00
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        // Edge cases: if numRows is 1 or greater than/equal to the string length,
        // the zigzag pattern is identical to the original string.
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Initialize a list of StringBuilders for each row
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goingDown = false;

        // Traverse the string and place characters into the correct row
        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            
            // Turn around when we reach the first or last row
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move up or down depending on the direction
            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}