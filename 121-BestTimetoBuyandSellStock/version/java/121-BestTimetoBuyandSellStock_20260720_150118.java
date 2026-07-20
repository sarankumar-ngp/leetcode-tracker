// Last updated: 20/07/2026, 15:01:18
1class Solution {
2    public int maxProfit(int[] prices) {
3        if (prices == null || prices.length == 0) {
4            return 0;
5        }
6
7        int minPrice = prices[0];
8        int maxProfit = 0;
9
10        for (int i = 1; i < prices.length; i++) {
11
12            if (prices[i] < minPrice) {
13                minPrice = prices[i];
14            } else {
15                int potentialProfit = prices[i] - minPrice;
16                if (potentialProfit > maxProfit) {
17                    maxProfit = potentialProfit;
18                }
19            }
20        }
21
22        return maxProfit;
23    }
24}