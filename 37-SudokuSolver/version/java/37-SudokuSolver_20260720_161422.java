// Last updated: 20/07/2026, 16:14:22
1class Solution {
2    public void solveSudoku(char[][] board) {
3        if (board == null || board.length == 0) {
4            return;
5        }
6        solve(board);
7    }
8    
9    private boolean solve(char[][] board) {
10        for (int row = 0; row < 9; row++) {
11            for (int col = 0; col < 9; col++) {
12                if (board[row][col] == '.') {
13                    // Try placing numbers 1 through 9
14                    for (char c = '1'; c <= '9'; c++) {
15                        if (isValid(board, row, col, c)) {
16                            board[row][col] = c; // Place the character
17                            
18                            if (solve(board)) {
19                                return true; // Found the correct sequence path
20                            }
21                            
22                            board[row][col] = '.'; // Backtrack
23                        }
24                    }
25                    return false; // Triggers backtracking if no digit fits
26                }
27            }
28        }
29        return true; // Entire board is filled successfully
30    }
31    
32    private boolean isValid(char[][] board, int row, int col, char c) {
33        for (int i = 0; i < 9; i++) {
34            // Check row constraints
35            if (board[i][col] == c) return false;
36            
37            // Check column constraints
38            if (board[row][i] == c) return false;
39            
40            // Check 3x3 sub-box constraints
41            int subBoxRowIndex = 3 * (row / 3) + i / 3;
42            int subBoxColIndex = 3 * (col / 3) + i % 3;
43            if (board[subBoxRowIndex][subBoxColIndex] == c) return false;
44        }
45        return true;
46    }
47}