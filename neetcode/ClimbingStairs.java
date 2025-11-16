class Solution {
    // THOUGHT PROCESS:
    // From any step you can choose to climb one step or two steps.
    // To end at step n your final move was either:
    //   - a one-step move from step n - 1, or
    //   - a two-step move from step n - 2.
    // Therefore the total ways to reach n = ways to reach n - 1 plus ways to reach n - 2.
    // Example: for n = 3 the sequences are (1,1,1), (1,2), (2,1) → ways(3) = ways(2) + ways(1) = 2 + 1 = 3.
    // Time: O(n). Space: O(n).
    
    // PSEUDOCODE:
    // 1. If n is 1 return 1. If n is 2 return 2.
    // 2. Make an array dp and set dp[1] = 1, dp[2] = 2.
    // 3. For each step from 3 to n set dp[step] = dp[step - 1] + dp[step - 2].
    // 4. Return dp[n].
    public int climbStairs(int n) {
        // base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // dp[step] = number of ways to reach step
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        // fill dp using the fact that from any step you can go 1 or 2 steps forward
        for (int step = 3; step <= n; step++) {
            dp[step] = dp[step - 1] + dp[step - 2];
        }

        return dp[n];
    }

    /*
    // Space-optimized version:
    public int climbStairs(int n) {
        int one = 1, two = 1;
        int prev = 1; // ways to reach step 1
        int curr = 2; // ways to reach step 2
        for (int step = 3; step <= n; step++) {
            int next = curr + prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    */
}