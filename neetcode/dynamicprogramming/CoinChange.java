import java.util.Arrays;

class Solution {

    // THOUGHT PROCESS:
    // Build the fewest coins needed for every amount from zero up to the target.
    // For each amount try each coin and keep the best (smallest) result.

    // PSEUDOCODE:
    // 1. Make dp array size amount+1, set all entries to amount+1 and dp[0]=0.
    // 2. For each current amount from 1 to amount:
    //    - for each coin that is not larger than current:
    //      - consider coins needed = dp[current - coin] + 1 and keep the smaller value.
    // 3. If dp[amount] is still larger than amount return -1, else return dp[amount].

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        if (coins == null || coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // unreachable marker
        dp[0] = 0;

        // build least coins for every amount
        for (int cur = 1; cur <= amount; cur++) {
            for (int coin : coins) {
                if (coin <= cur) {
                    // try using this coin: coins for remainder plus one
                    dp[cur] = Math.min(dp[cur], dp[cur - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}