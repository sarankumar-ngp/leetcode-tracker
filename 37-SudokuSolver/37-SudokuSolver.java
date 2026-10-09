// Last updated: 09/10/2026, 09:24:22
class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    // Try placing numbers 1 through 9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c; // Place the character
                            
                            if (solve(board)) {
                                return true; // Found the correct sequence path
                            }
                            
                            board[row][col] = '.'; // Backtrack
                        }
                    }
                    return false; // Triggers backtracking if no digit fits
                }
            }
        }
        return true; // Entire board is filled successfully
    }
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check row constraints
            if (board[i][col] == c) return false;
            
            // Check column constraints
            if (board[row][i] == c) return false;
            
            // Check 3x3 sub-box constraints
            int subBoxRowIndex = 3 * (row / 3) + i / 3;
            int subBoxColIndex = 3 * (col / 3) + i % 3;
            if (board[subBoxRowIndex][subBoxColIndex] == c) return false;
        }
        return true;
    }
}