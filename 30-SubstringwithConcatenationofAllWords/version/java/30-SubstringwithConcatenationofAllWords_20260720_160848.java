// Last updated: 20/07/2026, 16:08:48
1import java.util.ArrayList;
2import java.util.HashMap;
3import java.util.List;
4import java.util.Map;
5
6class Solution {
7    public List<Integer> findSubstring(String s, String[] words) {
8        List<Integer> result = new ArrayList<>();
9        if (s == null || s.length() == 0 || words == null || words.length == 0) {
10            return result;
11        }
12
13        int wordLen = words[0].length();
14        int wordCount = words.length;
15        int totalLen = wordLen * wordCount;
16        
17        if (s.length() < totalLen) {
18            return result;
19        }
20
21        // Count frequencies of each word in the input array
22        Map<String, Integer> wordFreq = new HashMap<>();
23        for (String word : words) {
24            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
25        }
26
27        // Run independent sliding windows for each possible character offset within a word length
28        for (int i = 0; i < wordLen; i++) {
29            int left = i;
30            Map<String, Integer> currentWords = new HashMap<>();
31            int count = 0; // Tracks the number of valid words matched in the current window
32
33            // Slide across the string in steps of wordLen
34            for (int right = i; right <= s.length() - wordLen; right += wordLen) {
35                String sub = s.substring(right, right + wordLen);
36
37                if (wordFreq.containsKey(sub)) {
38                    currentWords.put(sub, currentWords.getOrDefault(sub, 0) + 1);
39                    count++;
40
41                    // If a word's count exceeds its expected frequency, contract the window from the left
42                    while (currentWords.get(sub) > wordFreq.get(sub)) {
43                        String leftWord = s.substring(left, left + wordLen);
44                        currentWords.put(leftWord, currentWords.get(leftWord) - 1);
45                        count--;
46                        left += wordLen;
47                    }
48
49                    // If all words are successfully matched, capture the starting index
50                    if (count == wordCount) {
51                        result.add(left);
52                        // Shift left pointer forward by one word to continue tracking subsequent sequences
53                        String leftWord = s.substring(left, left + wordLen);
54                        currentWords.put(leftWord, currentWords.get(leftWord) - 1);
55                        count--;
56                        left += wordLen;
57                    }
58                } else {
59                    // Invalid word found: reset the tracking parameters entirely for the next sequence block
60                    currentWords.clear();
61                    count = 0;
62                    left = right + wordLen;
63                }
64            }
65        }
66
67        return result;
68    }
69}