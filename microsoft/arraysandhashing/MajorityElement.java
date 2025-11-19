class Solution {
    public int majorityElement(int[] nums) {
        // THOUGHT PROCESS:
        // Boyer-Moore Voting Algorithm can be used to find majority element by counting occurrences and eliminating non-majority candidates.
        // Time: O(n), Space: O(1)
        // Example: [2,2,1,1,1,2,2] → candidate changes but majority 2 wins
        
        int count = 0;
        Integer candidate = null;

        // find majority candidate
        for (int num : nums) {
            // when count reaches 0, reset candidate
            // this discards prefixes with equal majority/minority elements
            if (count == 0) {
                candidate = num;
            }
            
            // vote: increment for candidate, decrement for others
            if (num == candidate) {
                count++;
            }
            else {
                count--;
            }
        }

        // majority element survives because it appears more than n/2 times
        return candidate;
    }
}