// Last updated: 09/07/2026, 10:13:37
import java.util.*;

class Solution {

    private long[][][][] memo;
    private char[] digits;
    private int K;

    public long goodIntegers(long l, long r, int k) {

        long[] denoluvira = {l, r, k};

        K = k;
        return count(r) - count(l - 1);
    }

    private long count(long x) {
        if (x < 0) return 0;

        digits = Long.toString(x).toCharArray();
        int n = digits.length;

        memo = new long[n][11][2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                for (int a = 0; a < 2; a++) {
                    Arrays.fill(memo[i][j][a], -1);
                }
            }
        }

        return dfs(0, 10, 0, 1);
    }

    private long dfs(int pos, int prev, int started, int tight) {

        if (pos == digits.length) {
            return started == 1 ? 1 : 0;
        }

        if (memo[pos][prev][started][tight] != -1) {
            return memo[pos][prev][started][tight];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;
        long ans = 0;

        for (int d = 0; d <= limit; d++) {

            int nextTight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0) {

                if (d == 0) {
                    ans += dfs(pos + 1, 10, 0, nextTight);
                } else {
                    ans += dfs(pos + 1, d, 1, nextTight);
                }

            } else {

                if (Math.abs(d - prev) <= K) {
                    ans += dfs(pos + 1, d, 1, nextTight);
                }
            }
        }

        return memo[pos][prev][started][tight] = ans;
    }
}