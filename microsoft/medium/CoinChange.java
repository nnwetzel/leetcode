import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // THOUGHT PROCESS:
        // Brute force tries all combinations which is exponential and impractical
        
        // Better: Bottom-up DP building min coins for each amount
        // Time complexity: O(amount * coins.length) time, O(amount) space
        //
        // Pseudocode:
        // 1. Create dp array of size amount + 1 and fill with a large placeholder
        // 2. Set dp[0] = 0
        // 3. For each target amount from 1 to amount
        //    - For each coin in coins
        //    - If coin <= target then consider dp[target - coin] + 1
        // 4. If dp[amount] is still placeholder return -1 otherwise return dp[amount]

        // Allocate dp where dp[i] is the min coins to make amount i
        int[] dp = new int[amount + 1];

        // Initialize unreachable entries with a large number
        Arrays.fill(dp, amount + 1);

        // Zero coins needed to make amount zero
        dp[0] = 0;

        // Compute dp values
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // Only consider coin when it does not exceed the current target
                if (coin <= i) {
                    // dp[i - coin] is min coins to make the remainder; add one for this coin
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // Return -1 if impossible otherwise return computed minimum
        return dp[amount] > amount ? -1 : dp[amount];
    }
}