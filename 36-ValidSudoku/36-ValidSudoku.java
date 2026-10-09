// Last updated: 09/10/2026, 09:24:25
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Bitmasks for rows, columns, and 3x3 sub-boxes
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                
                // Only validate the filled cells
                if (ch != '.') {
                    int val = ch - '1'; // Scale '1'-'9' down to a 0-8 bit shift positioning
                    int mask = 1 << val;
                    
                    // Identify the sub-box index (0 to 8)
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    
                    // Check if the bit at position 'val' is already set in this row, col, or box
                    if ((rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                        return false;
                    }
                    
                    // Set the bit to record that we've seen this digit
                    rows[i] |= mask;
                    cols[j] |= mask;
                    boxes[boxIndex] |= mask;
                }
            }
        }
        
        return true;
    }
}