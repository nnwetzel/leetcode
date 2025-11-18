class Solution {
    // THOUGHT PROCESS:
    // Keep a running current sum ending at the current position. If adding the current
    // number is worse than starting fresh at that number, start fresh. Track the max seen.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE (plain English):
    // - Set maxSum to first number and currSum to first number.
    // - For each next number:
    //   * currSum = larger of (current number) and (currSum + current number)
    //   * maxSum = larger of maxSum and currSum
    // - Return maxSum

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // either start at current number or extend previous currSum
            currSum = Math.max(num, currSum + num);
            // update max subarray sum seen so far
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}