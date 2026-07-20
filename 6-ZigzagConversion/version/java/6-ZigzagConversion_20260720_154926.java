// Last updated: 20/07/2026, 15:49:26
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public String convert(String s, int numRows) {
6        // Edge cases: if numRows is 1 or greater than/equal to the string length,
7        // the zigzag pattern is identical to the original string.
8        if (numRows == 1 || numRows >= s.length()) {
9            return s;
10        }
11
12        // Initialize a list of StringBuilders for each row
13        List<StringBuilder> rows = new ArrayList<>();
14        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
15            rows.add(new StringBuilder());
16        }
17
18        int currRow = 0;
19        boolean goingDown = false;
20
21        // Traverse the string and place characters into the correct row
22        for (char c : s.toCharArray()) {
23            rows.get(currRow).append(c);
24            
25            // Turn around when we reach the first or last row
26            if (currRow == 0 || currRow == numRows - 1) {
27                goingDown = !goingDown;
28            }
29            
30            // Move up or down depending on the direction
31            currRow += goingDown ? 1 : -1;
32        }
33
34        // Combine all rows into a single string result
35        StringBuilder result = new StringBuilder();
36        for (StringBuilder row : rows) {
37            result.append(row);
38        }
39
40        return result.toString();
41    }
42}