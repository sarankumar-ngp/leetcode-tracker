// Last updated: 09/10/2026, 09:25:48
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: empty string matches empty pattern
        dp[0][0] = true;
        
        // Deal with patterns like a*, a*b*, or .* which can match an empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    // Current characters match, inherit from diagonal text state
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Two options when encountering '*':
                    // 1. Match 0 times: look at the state before the wildcard component (dp[i][j-2])
                    dp[i][j] = dp[i][j - 2];
                    
                    // 2. Match 1 or more times: if the preceding pattern char matches the current string char
                    char precedingChar = p.charAt(j - 2);
                    if (precedingChar == sc || precedingChar == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }
}
