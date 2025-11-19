import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // THOUGHT PROCESS:
        // Brute force: Compare every pair - O(n^2) time
        // Better: Use a hash set to track seen values - O(n) time, O(n) space
        //
        // PSEUDOCODE:
        // 1. Create an empty set for seen values
        // 2. For each number in nums
        //   - If number is in set return true
        //   - Otherwise add number to set
        // 3. Return false

        // Create set to record numbers we have seen so far
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // If number already seen then duplicate exists
            if (seen.contains(num)) return true;
            // Record number as seen
            seen.add(num);
        }

        // No duplicates found
        return false;
    }
}