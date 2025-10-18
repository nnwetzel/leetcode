class Solution {
    public int[] twoSum(int[] nums, int target) {
        // THOUGHT PROCESS:
        // Brute force: Check every pair with nested loops - O(n²) time
        // This checks all combinations but is too slow for large inputs
        //
        // Better: HashMap to store complements - O(n) time, O(n) space
        // Pseudocode:
        // 1. For each number, calculate its complement (target - number)
        // 2. Check if complement exists in HashMap
        // 3. If found: return indices of complement and current number
        // 4. If not found: store current number and index in HashMap
        
        Map<Integer, Integer> indices = new HashMap<>();
        
        // Single pass through array - O(n) iterations
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;
            
            // Check if complement exists in map
            if (indices.containsKey(complement)) {
                return new int[]{indices.get(complement), i};
            }
            
            // Store current number with its index for future lookups
            indices.put(current, i);
        }
        
        return new int[0];
    }
}

/* BRUTE FORCE SOLUTION (for reference):
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return new int[0];
}
*/
