class Solution {
    public int maxProfit(int[] prices) {
        // THOUGHT PROCESS:
        // Brute force: Check every buy-sell pair - O(n²) time
        // Too slow for large inputs
        //
        // Optimal: Track minimum price so far and update max profit - O(n) time, O(1) space
        // Key: Always buy at the lowest price seen so far to maximize profit
        // Pseudocode:
        // 1. Track the lowest price seen so far (so we always consider the best buy)
        // 2. For each price, if it's lower than minPrice, update minPrice
        // 3. Otherwise, check if selling at this price gives a better profit
        // 4. Update maxProfit if needed

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            // If the price is less than min price so far, update minPrice
            if (price < minPrice) {
                minPrice = price;
            }
            // Otherwise, check if selling now gives a better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

/* BRUTE FORCE SOLUTION (for reference):
public int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
        for (int j = i + 1; j < prices.length; j++) {
            maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        }
    }
    return maxProfit;
}
*/