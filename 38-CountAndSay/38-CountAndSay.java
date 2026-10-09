// Last updated: 09/10/2026, 09:24:17
class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        String current = "1";
        
        // Iteratively generate the sequence up to n
        for (int i = 1; i < n; i++) {
            StringBuilder nextString = new StringBuilder();
            int length = current.length();
            
            int count = 1;
            for (int j = 1; j < length; j++) {
                // If the current character matches the previous one, increment count
                if (current.charAt(j) == current.charAt(j - 1)) {
                    count++;
                } else {
                    // Append the count followed by the digit character itself
                    nextString.append(count).append(current.charAt(j - 1));
                    count = 1; // Reset count for the new character group
                }
            }
            // Append the last remaining group sequence block
            nextString.append(count).append(current.charAt(length - 1));
            current = nextString.toString();
        }
        
        return current;
    }
}