class Solution {
    // THOUGHT PROCESS:
    // Use dynamic programming to find the most money we can rob
    // without robbing two houses next to each other.
    // Time complexity: O(n)
    // Space complexity: O(n)
    //
    // Pseudocode:
    // 1. Handle edge cases:
    //    - No houses → 0
    //    - One house → its value
    // 2. Use dp[i] to store the best total up to house i
    // 3. Base cases:
    //    - First house → its value
    //    - Second house → larger of the two
    // 4. For each next house:
    //    - Skip it or rob it (add value from two back)
    // 5. Return the last dp value

    public int rob(int[] nums) {
        int n = nums.length;

        // If there are no houses -> $0
        if (n == 0) return 0;

        // If there is 1 house -> $ of that house
        if (n == 1) return nums[0];

        // dp[i] = max money robbed from first i houses
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Go through the rest of the houses
        for (int i = 2; i < n; i++) {
            int skip = dp[i - 1];           // Skip this house
            int rob = dp[i - 2] + nums[i];  // Rob this house
            dp[i] = Math.max(skip, rob);
        }

        return dp[n - 1];
    }
}