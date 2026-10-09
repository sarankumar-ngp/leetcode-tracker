// Last updated: 09/10/2026, 09:25:26
import java.util.ArrayList;
import java.util.List;

class Solution {
    // Mapping of digits to corresponding telephone characters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: if the input string is empty, return an empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // Base case: if the current combination length matches the input length, add to results
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];
        
        // Loop through each possible letter for the current digit
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));          // Choose
            backtrack(result, digits, current, index + 1); // Explore
            current.deleteCharAt(current.length() - 1); // Unchoose (backtrack)
        }
    }
}