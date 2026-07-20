// Last updated: 20/07/2026, 16:20:33
1class Solution {
2    public boolean isValidSudoku(char[][] board) {
3        // Bitmasks for rows, columns, and 3x3 sub-boxes
4        int[] rows = new int[9];
5        int[] cols = new int[9];
6        int[] boxes = new int[9];
7        
8        for (int i = 0; i < 9; i++) {
9            for (int j = 0; j < 9; j++) {
10                char ch = board[i][j];
11                
12                // Only validate the filled cells
13                if (ch != '.') {
14                    int val = ch - '1'; // Scale '1'-'9' down to a 0-8 bit shift positioning
15                    int mask = 1 << val;
16                    
17                    // Identify the sub-box index (0 to 8)
18                    int boxIndex = (i / 3) * 3 + (j / 3);
19                    
20                    // Check if the bit at position 'val' is already set in this row, col, or box
21                    if ((rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
22                        return false;
23                    }
24                    
25                    // Set the bit to record that we've seen this digit
26                    rows[i] |= mask;
27                    cols[j] |= mask;
28                    boxes[boxIndex] |= mask;
29                }
30            }
31        }
32        
33        return true;
34    }
35}