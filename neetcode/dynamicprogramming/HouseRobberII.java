class Solution {
    // THOUGHT PROCESS:
    // A circular street means either you skip the first house or skip the last house.
    // Solve two linear House Robber problems (exclude first or exclude last) and take the max.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. If there is only one house return its value.
    // 2. Compute best loot when skipping the first house.
    // 3. Compute best loot when skipping the last house.
    // 4. Return the larger result.
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        // solve two linear cases: [1..n-1] and [0..n-2]
        int skipFirst = helper(Arrays.copyOfRange(nums, 1, nums.length));      // exclude house 0
        int skipLast  = helper(Arrays.copyOfRange(nums, 0, nums.length - 1));  // exclude last house
        return Math.max(skipFirst, skipLast);
    }

    // PSEUDOCODE:
    // 1. Handle base cases for no houses or one house.
    // 2. Use dp[i] to store the best total up to house i
    // 3. Base cases:
    //    - First house → its value
    //    - Second house → larger of the two
    // 4. For each next house:
    //    - Skip it or rob it (add value from two back)
    // 5. Return the last dp value
    public int helper(int[] nums) {
        int n = nums.length;

        // if there are no houses -> $0
        if (n == 0) return 0;
        // if there is 1 house -> $ of that house
        if (n == 1) return nums[0];

        int[] dp = new int[n];

        // first house -> its value
        dp[0] = nums[0];
        // second house -> larger of the two
        dp[1] = Math.max(nums[0], nums[1]);

        // go through the rest of the houses
        for (int i = 2; i < n; i++) {
            // skip this house
            int skip = dp[i - 1];    
            // rob this house       
            int rob = dp[i - 2] + nums[i];  
            // choose the better option
            dp[i] = Math.max(skip, rob);
        }
        return dp[n - 1];
    }
}