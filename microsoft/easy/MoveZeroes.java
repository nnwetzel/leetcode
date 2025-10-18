class Solution {
    public void moveZeroes(int[] nums) {
        // THOUGHT PROCESS:
        // Two-pass approach - O(n) time, O(1) space
        // Pseudocode:
        // 1. First pass: move all non-zero elements to front, track position
        // 2. Second pass: fill remaining positions with zeros
        // 3. Maintains relative order of non-zero elements
        
        int position = 0;
        
        // First pass: move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[position++] = num; // Place non-zero at current position, then increment
            }
        }
        
        // Second pass: fill remaining positions with zeros
        while (position < nums.length) {
            nums[position++] = 0; // Fill rest of array with zeros
        }
    }
}