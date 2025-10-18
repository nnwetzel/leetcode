class Solution {
    public int maxSubArray(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: Try every subarray - O(n²) - Too slow!
        // Example: For [5,4,-1,7], check [5], [5,4], [5,4,-1], [5,4,-1,7], [4], [4,-1], etc.
        // This is inefficient because we recalculate overlapping sums
        //
        // Better: Dynamic Programming approach - O(n) time, O(1) space
        // Pseudocode:
        // 1. Initialize maxSum = first element, currentSum = 0
        // 2. For each element:
        //    - If currentSum < 0: restart (use 0), otherwise extend
        //    - Add current element to get new currentSum
        //    - Update maxSum if currentSum is better
        
        // Example: [-2,1,-3,4,-1,2,1] → best subarray is [4,-1,2,1] = 6
        
        int maxSum = nums[0];
        int currentSum = 0;

        for (int num : nums) {
            // WHEN DO WE RESTART?
            // We restart when currentSum becomes negative because a negative sum hurts any future elements
            // Math.max(0, currentSum) chooses:
            //   - 0 if currentSum < 0 (RESTART: throw away negative sum)
            //   - currentSum if currentSum >= 0 (EXTEND: keep building)
            
            // Example: currentSum=-2, num=4 → max(0,-2)+4 = 4 (RESTART!)
            // Example: currentSum=3, num=2 → max(0,3)+2 = 5 (EXTEND)
            currentSum = Math.max(0, currentSum) + num;
            
            // Track best sum seen so far
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}

/* BRUTE FORCE SOLUTION:
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        
        return maxSum;
    }
}
*/