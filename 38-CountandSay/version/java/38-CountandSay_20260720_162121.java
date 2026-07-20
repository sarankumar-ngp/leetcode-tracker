// Last updated: 20/07/2026, 16:21:21
1class Solution {
2    public String countAndSay(int n) {
3        if (n <= 0) {
4            return "";
5        }
6        
7        String current = "1";
8        
9        // Iteratively generate the sequence up to n
10        for (int i = 1; i < n; i++) {
11            StringBuilder nextString = new StringBuilder();
12            int length = current.length();
13            
14            int count = 1;
15            for (int j = 1; j < length; j++) {
16                // If the current character matches the previous one, increment count
17                if (current.charAt(j) == current.charAt(j - 1)) {
18                    count++;
19                } else {
20                    // Append the count followed by the digit character itself
21                    nextString.append(count).append(current.charAt(j - 1));
22                    count = 1; // Reset count for the new character group
23                }
24            }
25            // Append the last remaining group sequence block
26            nextString.append(count).append(current.charAt(length - 1));
27            current = nextString.toString();
28        }
29        
30        return current;
31    }
32}