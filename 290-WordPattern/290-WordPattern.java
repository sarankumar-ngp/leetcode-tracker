// Last updated: 28/07/2026, 15:43:20
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Split the string s into individual words
        String[] words = s.split(" ");
        
        // If the number of characters doesn't match the number of words, a bijection is impossible
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Two maps to track the forward (char -> word) and reverse (word -> char) relationships
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            // Check char -> word mapping
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }
            
            // Check word -> char mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }
        
        return true;
    }
}