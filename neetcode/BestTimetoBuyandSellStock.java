class Solution {
    // THOUGHT PROCESS:
    // Go through the price list once, remembering the lowest price seen so far (best day to buy).
    // For each day, consider selling at the current price and update the best profit if that beat the previous best.
    // This guarantees the buy day is before the sell day.
    // Time: O(n). Space: O(1).
    
    // PSEUDOCODE:
    // 1. Start with minPrice very large and bestProfit zero.
    // 2. For each price in the list:
    //    - If the price is lower than minPrice, record it as the new minPrice (better buy).
    //    - Otherwise, compute profit by selling at this price and update bestProfit if it's larger.
    // 3. Return bestProfit.

    public int maxProfit(int[] prices) {
        // best profit found so far
        int maxProfit = 0;
         // lowest price seen so far (best buy)
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            // update minPrice when we find a cheaper buying day
            if (price < minPrice) {
                minPrice = price;
            } else {
                // selling today yields profit = price - minPrice; update if it's the best so far
                int profit = price - minPrice;
                if (profit > maxProfit) maxProfit = profit;
            }
        }

        return maxProfit;
    }
}