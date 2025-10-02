class Solution {
    public int removeDuplicates(int[] nums) {
        // Two pointer approach for O(n) in-place solution
        // Intuition: Since array is sorted, duplicates are adjacent
        // Use one pointer to read and another to write unique elements
        
        int insertIndex = 1;
        
        // Start from index 1 since first element is always unique
        for (int i = 1; i < nums.length; i++) {
            // Found a new unique element (different from previous)
            if (nums[i - 1] != nums[i]) {
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        
        // Return length of array with unique elements
        return insertIndex;
    }
}