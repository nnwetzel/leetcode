class Solution {
    public int majorityElement(int[] nums) {
        // Boyer-Moore Voting Algorithm - O(n) time, O(1) space
        // Intuition: Count majority element as +1, others as -1, majority survives
        // Example: [2,2,1,1,1,2,2] → candidate changes but majority 2 wins
        
        int count = 0;
        Integer candidate = null;

        // Find majority candidate - O(n) time
        for (int num : nums) {
            // When count reaches 0, reset candidate
            // This discards prefixes with equal majority/minority elements
            if (count == 0) {
                candidate = num;
            }
            
            // Vote: increment for candidate, decrement for others
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Majority element survives because it appears more than n/2 times
        return candidate;
    }
}