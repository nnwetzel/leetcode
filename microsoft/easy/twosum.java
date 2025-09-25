class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hash Map approach for O(n) solution
        // Intuition: For each number, check if its complement (target - number) exists
        // Store each number with its index as we iterate
        
        Map<Integer, Integer> indices = new HashMap<>();

        // First pass: populate hash map with all numbers and their indices
        for (int i = 0; i < nums.length; i++) {
            indices.put(nums[i], i);
        }

        // Second pass: for each number, look for its complement
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists and is not the same element
            // (handles case where same value appears twice but we need different indices)
            if (indices.containsKey(complement) && indices.get(complement) != i) {
                return new int[]{i, indices.get(complement)};
            }
        }
        
        // Should never reach here given problem constraints guarantee solution exists
        return new int[0];
    }
}
