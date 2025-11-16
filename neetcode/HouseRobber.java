class Solution {
    // THOUGHT PROCESS:
    // Use dynamic programming to find the most money we can rob
    // without robbing two houses next to each other.
    // Time: O(n), Space: O(n).
    //
    // PSEUDOCODE:
    // 1. Handle base cases for no houses or one house.
    // 2. Use dp[i] to store the best total up to house i
    // 3. Base cases:
    //    - First house → its value
    //    - Second house → larger of the two
    // 4. For each next house:
    //    - Skip it or rob it (add value from two back)
    // 5. Return the last dp value
    public int rob(int[] nums) {
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