class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hash Map approach for O(n) solution
        // Intuition: For each number, check if its difference (target - number) exists
        // Store each number with its index as we iterate
        
        Map<Integer, Integer> indices = new HashMap<>();
        
        // Single pass: for each number, look for its difference
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            // Calculate what number we need to add to current to reach target
            // If current + difference = target, then difference = target - current
            int difference = target - current;
            
            // Check if difference exists in our map
            // If found, we have our pair of indices
            if (indices.containsKey(difference)) {
                return new int[]{indices.get(difference), i};
            }
            
            // Store current number with its index for future lookups
            indices.put(current, i);
        }
        
        // Should never reach here given problem constraints guarantee solution exists
        return new int[0];
    }
}
