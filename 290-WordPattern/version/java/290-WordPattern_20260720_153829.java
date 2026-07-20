// Last updated: 20/07/2026, 15:38:29
1import java.util.HashMap;
2
3class Solution {
4    public boolean wordPattern(String pattern, String s) {
5        // Split the string s into individual words
6        String[] words = s.split(" ");
7        
8        // If the number of characters doesn't match the number of words, a bijection is impossible
9        if (pattern.length() != words.length) {
10            return false;
11        }
12        
13        // Two maps to track the forward (char -> word) and reverse (word -> char) relationships
14        HashMap<Character, String> charToWord = new HashMap<>();
15        HashMap<String, Character> wordToChar = new HashMap<>();
16        
17        for (int i = 0; i < pattern.length(); i++) {
18            char c = pattern.charAt(i);
19            String word = words[i];
20            
21            // Check char -> word mapping
22            if (charToWord.containsKey(c)) {
23                if (!charToWord.get(c).equals(word)) {
24                    return false;
25                }
26            } else {
27                charToWord.put(c, word);
28            }
29            
30            // Check word -> char mapping
31            if (wordToChar.containsKey(word)) {
32                if (wordToChar.get(word) != c) {
33                    return false;
34                }
35            } else {
36                wordToChar.put(word, c);
37            }
38        }
39        
40        return true;
41    }
42}