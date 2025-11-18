class Solution {
    public int[] runningSum(int[] nums) {
        // THOUGHT PROCESS:
        // Running sum approach
        // Time: O(n). Space: O(1).

        // PSEUDOCODE:
        // 1. Start from index 1 (first element already correct)
        // 2. For each position, add previous running sum
        // 3. Current element becomes running sum up to that point
        // 4. Return modified array
        
        for (int i = 1; i < nums.length; i++) {
            // key insight: nums[i] = nums[i] + nums[i-1] gives running sum
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}