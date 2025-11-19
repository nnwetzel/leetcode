class Solution {
    public int longestConsecutive(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: For each number, search array for consecutive sequence - O(n³) time
        // This repeatedly searches the array which is very inefficient
        //
        // Better: HashSet for O(1) lookups - O(n) time, O(n) space
        // Pseudocode:
        // 1. Put all numbers in HashSet for O(1) contains() checks
        // 2. For each number, check if it's the start of a sequence (no num-1)
        // 3. If it's a start, count consecutive numbers going forward
        // 4. Track maximum sequence length found
        
        Set<Integer> numSet = new HashSet<>();
        // Create HashSet for O(1) lookups
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if this number is the start of a sequence
            // (no number before it exists, so num-1 is not in set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers going forward from this start
                // Keep checking if next number (currentNum + 1) exists in set
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;      // Move to next number in sequence
                    currentStreak++;   // Increase sequence length
                }

                // Update longest sequence found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}

/* BRUTE FORCE SOLUTION:
public int longestConsecutive(int[] nums) {
    int longestStreak = 0;
    
    for (int num : nums) {
        int currentNum = num;
        int currentStreak = 1;
        
        // Count sequence going forward
        while (arrayContains(nums, currentNum + 1)) {
            currentNum++;
            currentStreak++;
        }
        
        longestStreak = Math.max(longestStreak, currentStreak);
    }
    
    return longestStreak;
}

private boolean arrayContains(int[] nums, int target) {
    for (int num : nums) {
        if (num == target) return true;
    }
    return false;
}
*/