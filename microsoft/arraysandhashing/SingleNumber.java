import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        // THOUGHT PROCESS:
        // HashMap approach to count occurrences - O(n) time, O(n) space
        // Pseudocode:
        // 1. Count frequency of each number using HashMap
        // 2. Iterate through array again to find number with count 1
        // 3. Return that single occurrence number
        
        HashMap<Integer, Integer> numCounts = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }
        
        // Find the number that appears only once
        for (int num : nums) {
            if (numCounts.get(num) == 1) {
                return num;
            }
        }
        
        return 0;
    }
}