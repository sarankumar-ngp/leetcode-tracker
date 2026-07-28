// Last updated: 28/07/2026, 15:44:18
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int potentialProfit = prices[i] - minPrice;
                if (potentialProfit > maxProfit) {
                    maxProfit = potentialProfit;
                }
            }
        }

        return maxProfit;
    }
}