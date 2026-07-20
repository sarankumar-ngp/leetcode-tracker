// Last updated: 20/07/2026, 15:51:47
1class Solution {
2    public boolean isMatch(String s, String p) {
3        int m = s.length();
4        int n = p.length();
5        
6        // dp[i][j] will be true if s[0..i-1] matches p[0..j-1]
7        boolean[][] dp = new boolean[m + 1][n + 1];
8        
9        // Base case: empty string matches empty pattern
10        dp[0][0] = true;
11        
12        // Deal with patterns like a*, a*b*, or .* which can match an empty string
13        for (int j = 2; j <= n; j++) {
14            if (p.charAt(j - 1) == '*') {
15                dp[0][j] = dp[0][j - 2];
16            }
17        }
18        
19        for (int i = 1; i <= m; i++) {
20            for (int j = 1; j <= n; j++) {
21                char sc = s.charAt(i - 1);
22                char pc = p.charAt(j - 1);
23                
24                if (pc == sc || pc == '.') {
25                    // Current characters match, inherit from diagonal text state
26                    dp[i][j] = dp[i - 1][j - 1];
27                } else if (pc == '*') {
28                    // Two options when encountering '*':
29                    // 1. Match 0 times: look at the state before the wildcard component (dp[i][j-2])
30                    dp[i][j] = dp[i][j - 2];
31                    
32                    // 2. Match 1 or more times: if the preceding pattern char matches the current string char
33                    char precedingChar = p.charAt(j - 2);
34                    if (precedingChar == sc || precedingChar == '.') {
35                        dp[i][j] = dp[i][j] || dp[i - 1][j];
36                    }
37                }
38            }
39        }
40        
41        return dp[m][n];
42    }
43}
44