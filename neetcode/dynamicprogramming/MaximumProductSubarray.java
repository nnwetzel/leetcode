class Solution {
    // THOUGHT PROCESS:
    // A negative number flips signs so the largest product can become the smallest and vice versa.
    // Keep the best and worst products ending at the current position. If the current number is negative,
    // swap them before updating. At each step either start fresh at the current number or extend the previous product.
    // Time: O(n). Space: O(1).

    // PSEUDOCODE:
    // 1. Set current max, current min, and result to first number.
    // 2. For each next number:
    //    - If number is negative swap current max and min.
    //    - Update current max to the larger of number and current max times number.
    //    - Update current min to the smaller of number and current min times number.
    //    - Update result if current max is larger.
    // 3. Return result.
    public int maxProduct(int[] nums) {
        // largest product ending here
        int currMax = nums[0];
        // smallest product ending here (needed when negative)
        int currMin = nums[0];
        // best product seen so far
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // negative flips max/min roles
            if (x < 0) {
                int tmp = currMax;
                currMax = currMin;
                currMin = tmp;
            }

            // either start at x or extend previous product
            currMax = Math.max(x, currMax * x);
            currMin = Math.min(x, currMin * x);

            // update global best
            result = Math.max(result, currMax);
        }
        return result;
    }
}
