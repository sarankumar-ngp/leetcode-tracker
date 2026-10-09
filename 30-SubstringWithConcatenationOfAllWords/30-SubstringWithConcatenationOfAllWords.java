// Last updated: 09/10/2026, 09:24:43
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        
        if (s.length() < totalLen) {
            return result;
        }

        // Count frequencies of each word in the input array
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        // Run independent sliding windows for each possible character offset within a word length
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            Map<String, Integer> currentWords = new HashMap<>();
            int count = 0; // Tracks the number of valid words matched in the current window

            // Slide across the string in steps of wordLen
            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
                String sub = s.substring(right, right + wordLen);

                if (wordFreq.containsKey(sub)) {
                    currentWords.put(sub, currentWords.getOrDefault(sub, 0) + 1);
                    count++;

                    // If a word's count exceeds its expected frequency, contract the window from the left
                    while (currentWords.get(sub) > wordFreq.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentWords.put(leftWord, currentWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If all words are successfully matched, capture the starting index
                    if (count == wordCount) {
                        result.add(left);
                        // Shift left pointer forward by one word to continue tracking subsequent sequences
                        String leftWord = s.substring(left, left + wordLen);
                        currentWords.put(leftWord, currentWords.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    // Invalid word found: reset the tracking parameters entirely for the next sequence block
                    currentWords.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}