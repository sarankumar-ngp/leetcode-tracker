// Last updated: 20/07/2026, 16:01:21
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> generateParenthesis(int n) {
6        List<String> result = new ArrayList<>();
7        backtrack(result, new StringBuilder(), 0, 0, n);
8        return result;
9    }
10
11    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
12        // Base case: if the current combination length reaches the maximum possible length
13        if (current.length() == max * 2) {
14            result.add(current.toString());
15            return;
16        }
17
18        // If we can still add open parentheses, add one and explore
19        if (open < max) {
20            current.append('(');
21            backtrack(result, current, open + 1, close, max);
22            current.deleteCharAt(current.length() - 1); // Backtrack
23        }
24
25        // If we can validly add close parentheses, add one and explore
26        if (close < open) {
27            current.append(')');
28            backtrack(result, current, open, close + 1, max);
29            current.deleteCharAt(current.length() - 1); // Backtrack
30        }
31    }
32}