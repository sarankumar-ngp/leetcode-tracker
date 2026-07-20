// Last updated: 20/07/2026, 15:56:48
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    // Mapping of digits to corresponding telephone characters
6    private static final String[] KEYPAD = {
7        "",     // 0
8        "",     // 1
9        "abc",  // 2
10        "def",  // 3
11        "ghi",  // 4
12        "jkl",  // 5
13        "mno",  // 6
14        "pqrs", // 7
15        "tuv",  // 8
16        "wxyz"  // 9
17    };
18
19    public List<String> letterCombinations(String digits) {
20        List<String> result = new ArrayList<>();
21        
22        // Edge case: if the input string is empty, return an empty list
23        if (digits == null || digits.length() == 0) {
24            return result;
25        }
26        
27        backtrack(result, digits, new StringBuilder(), 0);
28        return result;
29    }
30
31    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
32        // Base case: if the current combination length matches the input length, add to results
33        if (index == digits.length()) {
34            result.add(current.toString());
35            return;
36        }
37
38        // Get the letters corresponding to the current digit
39        String letters = KEYPAD[digits.charAt(index) - '0'];
40        
41        // Loop through each possible letter for the current digit
42        for (int i = 0; i < letters.length(); i++) {
43            current.append(letters.charAt(i));          // Choose
44            backtrack(result, digits, current, index + 1); // Explore
45            current.deleteCharAt(current.length() - 1); // Unchoose (backtrack)
46        }
47    }
48}